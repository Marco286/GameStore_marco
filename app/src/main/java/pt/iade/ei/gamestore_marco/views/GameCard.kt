package pt.iade.ei.gamestore_marco.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore_marco.model.Game
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore_marco.R

@Composable
fun GameCard(game: Game, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            // Background image
            Image(
                painter = painterResource(id = game.imageRes),
                contentDescription = game.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Gradient overlay (makes text readable)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xAA000000)
                            )
                        )
                    )
            )

            // Game name text
            Text(
                text = game.name,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GameCardPreview() {
    val sample = Game(
        id = 1,
        name = "Fortnite",
        description = "Battle royale cheio de ação",
        imageRes = R.drawable.fortnitelogo,   // ← vírgula OBRIGATÓRIA aqui
        items = emptyList()
    )

    GameCard(game = sample, onClick = {})
}
