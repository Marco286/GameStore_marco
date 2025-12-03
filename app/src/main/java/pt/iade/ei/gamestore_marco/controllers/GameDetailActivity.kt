package pt.iade.ei.gamestore_marco.controllers

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.IntrinsicSize
import pt.iade.ei.gamestore_marco.R
import pt.iade.ei.gamestore_marco.model.Game
import pt.iade.ei.gamestore_marco.model.StoreItem
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme
import pt.iade.ei.gamestore_marco.views.StoreItemCard

class GameDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val game = intent.getParcelableExtra<Game>("game")

        if (game == null) {
            finish()
            return
        }

        setContent {
            GameStore_marcoTheme {
                GameDetailScreen(game = game)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(game: Game) {
    val context = LocalContext.current

    var selectedItem by remember { mutableStateOf<StoreItem?>(null) }
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            // TOP BAR — sem coração
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // ← botão voltar
                Text(
                    text = "←",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.clickable {
                        (context as? Activity)?.finish()
                    }
                )

                Spacer(Modifier.width(16.dp))

                // Nome do jogo
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {

            // IMAGE + DESCRIPTION SIDE BY SIDE
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.Top
            ) {

                // IMAGEM
                Image(
                    painter = painterResource(id = game.imageRes),
                    contentDescription = game.name,
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(16.dp))

                // DESCRIÇÃO COMPLETA, SEM CORTE
                Text(
                    text = game.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.weight(1f),
                    maxLines = Int.MAX_VALUE,
                    softWrap = true
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // TÍTULO LISTA
            Text(
                text = "Purchasable Items",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // LISTA DE ITEMS
            LazyColumn {
                items(game.items) { item ->
                    StoreItemCard(
                        item = item,
                        onClick = {
                            selectedItem = item
                            showBottomSheet = true
                        }
                    )
                }
            }
        }

        // BOTTOM SHEET (mantém igual)
        if (showBottomSheet && selectedItem != null) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    Text(selectedItem!!.name, style = MaterialTheme.typography.titleLarge)
                    Spacer(Modifier.height(8.dp))
                    Text(selectedItem!!.description)
                    Spacer(Modifier.height(12.dp))
                    Text("Preço: $${selectedItem!!.price}")
                    Spacer(Modifier.height(24.dp))
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Acabou de comprar o item ${selectedItem!!.name} por \$${selectedItem!!.price}",
                                Toast.LENGTH_LONG
                            ).show()
                            showBottomSheet = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Comprar")
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GameDetailScreenPreview() {

    val sampleGame = Game(
        id = 1,
        name = "Fortnite",
        description = "Fortnite é um jogo eletrónico multijogador online com muitos modos de jogo, itens colecionáveis e eventos ao vivo.",
        imageRes = R.drawable.fortnitelogo,
        items = listOf(
            StoreItem(1, "Skin Iconic", "Skin super bonita.", 14.89, R.drawable.icoicfortnite),
            StoreItem(2, "13.500 V-Bucks", "Pack de v-bucks premium.", 13.50, R.drawable.vbucksfortnite)
        )
    )

    GameStore_marcoTheme {
        GameDetailScreen(game = sampleGame)
    }
}
