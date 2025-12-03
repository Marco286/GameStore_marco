package pt.iade.ei.gamestore_marco.controllers

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import pt.iade.ei.gamestore_marco.R
import pt.iade.ei.gamestore_marco.model.Game
import pt.iade.ei.gamestore_marco.model.StoreItem
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme
import pt.iade.ei.gamestore_marco.controllers.GameDetailActivity
import pt.iade.ei.gamestore_marco.views.GameCard
import androidx.compose.ui.tooling.preview.Preview



private val sampleGames = listOf(
    Game(
        id = 1,
        name = "Fortnite",
        description = "Fortnite é um jogo eletrônico multijogador online e uma plataforma de jogos desenvolvida pela Epic Games e lançada em 2017.",
        imageRes = R.drawable.fortnitelogo,
        items = listOf(
            StoreItem(1, "Skin Iconic", "Fica mais bonito com a recente skin Iconic.", 14.89, R.drawable.icoicfortnite),
            StoreItem(2, "13.500 V-Bucks", "Com todas estas v-bucks compras o passe de batalha...", 13.50, R.drawable.vbucksfortnite),
            StoreItem(3, "Passe de Batalha", "Completa todos os níveis e recebes inúmeros prémios!", 9.99, R.drawable.passedebatalhafort)
        )
    ),
    Game(
        id = 2,
        name = "Pokemon",
        description = "Pokémon GO é um jogo eletrônico free-to-play de realidade aumentada voltado para smartphones. O jogo é desenvolvido e publicado pela Niantic, Inc., em colaboração com a Nintendo e a The Pokémon Company",
        imageRes = R.drawable.pokemongo,
        items = listOf(
            StoreItem(4, "100 Pokebolas", "Inúmeras pokebolas para caçar pokemons.", 10.99, R.drawable.pokebolas),
            StoreItem(5, "150 Pokecoins", "Compra pokebolas e poções.", 7.99, R.drawable.pokecoins),
            StoreItem(6, "Raid Pass", "Luta nos ginásios para capturar pokemons.", 11.49, R.drawable.raidpass)
        )
    )
)

// ------------------------------------------------------------
// MAIN ACTIVITY
// ------------------------------------------------------------
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GameStore_marcoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    GameListScreen(
                        games = sampleGames,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// ------------------------------------------------------------
// LISTA DE JOGOS (TOP + CARDS)
// ------------------------------------------------------------
@Composable
fun GameListScreen(games: List<Game>, modifier: Modifier = Modifier) {

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        // TÍTULO






        // LISTA DE CARDS
        LazyColumn {
            items(games) { game ->
                GameCard(
                    game = game,
                    onClick = {
                        val intent = Intent(context, GameDetailActivity::class.java)
                        intent.putExtra("game", game)
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
    val sampleGames = listOf(
        Game(
            id = 1,
            name = "Fortnite",
            description = "Battle royale!",
            imageRes = R.drawable.fortnitelogo,
            items = emptyList()
        ),
        Game(
            id = 2,
            name = "Pokemon",
            description = "Cata Pokémons na rua!",
            imageRes = R.drawable.pokemongo,
            items = emptyList()
        )
    )

    GameStore_marcoTheme {
        GameListScreen(games = sampleGames)
    }
}