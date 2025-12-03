package pt.iade.ei.gamestore_marco.ui.screens

import android.widget.Toast
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore_marco.model.Game
import pt.iade.ei.gamestore_marco.model.StoreItem
import pt.iade.ei.gamestore_marco.ui.components.StoreItemCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(game: Game) {

    val context = LocalContext.current
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    var selectedItem by remember { mutableStateOf<StoreItem?>(null) }
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    // ---------- BOTTOM SHEET ----------
    if (showSheet && selectedItem != null) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { showSheet = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Text(
                    text = selectedItem!!.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = selectedItem!!.imageRes),
                        contentDescription = selectedItem!!.name,
                        modifier = Modifier
                            .size(140.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = selectedItem!!.description,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Preço: €${"%.2f".format(selectedItem!!.price)}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        Toast.makeText(
                            context,
                            "Comprou ${selectedItem!!.name} por €${selectedItem!!.price}",
                            Toast.LENGTH_LONG
                        ).show()
                        showSheet = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = "Comprar com 1 toque",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
            }
        }
    } // ← ESTA CHAVETA FALTAVA! AGORA FECHA O IF CORRETAMENTE

    // ---------- MAIN SCREEN ----------
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(game.name, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { dispatcher?.onBackPressed() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Outlined.StarBorder,
                            contentDescription = "Favorito"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.Top
                ) {

                    Image(
                        painter = painterResource(id = game.imageRes),
                        contentDescription = game.name,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(20.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = game.description,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        softWrap = true,
                        maxLines = Int.MAX_VALUE
                    )
                }
            }

            item {
                Text(
                    "Purchasable Items",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 12.dp)
                )
            }

            items(game.items) { item ->
                StoreItemCard(
                    item = item,
                    onClick = {
                        selectedItem = item
                        showSheet = true
                    }
                )
            }
        }
    }
}
