package pt.iade.ei.gamestore_marco.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore_marco.GameDetailActivity
import pt.iade.ei.gamestore_marco.MainActivity
import pt.iade.ei.gamestore_marco.R
import pt.iade.ei.gamestore_marco.model.Game
import pt.iade.ei.gamestore_marco.ui.components.GameCard
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme

@Composable
fun GameListScreen(
    games: List<Game>,
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 78.dp, bottom = 16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logosmile),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )

            Text(
                text = "SmileShop",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(games) { game ->
                GameCard(
                    game = game,
                    onClick = {
                        val intent = Intent(context, GameDetailActivity::class.java)
                        intent.putExtra(MainActivity.EXTRA_GAME, game)
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GameListScreenPreview() {
    GameStore_marcoTheme {
        GameListScreen(
            games = listOf(
                Game(
                    id = 1,
                    name = "Fortnite",
                    description = "Battle royale",
                    imageRes = R.drawable.fortnitelogo,
                    items = emptyList()
                ),
                Game(
                    id = 2,
                    name = "Pokemon GO",
                    description = "Realidade aumentada",
                    imageRes = R.drawable.pokemongo,
                    items = emptyList()
                )
            )
        )
    }
}
