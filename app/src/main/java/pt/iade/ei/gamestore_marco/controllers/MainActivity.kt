package pt.iade.ei.gamestore_marco.controllers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pt.iade.ei.gamestore_marco.R
import pt.iade.ei.gamestore_marco.model.Game
import pt.iade.ei.gamestore_marco.model.StoreItem
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme
import pt.iade.ei.gamestore_marco.views.GameCard


private val sampleGames = listOf(
    Game(
        id = 1,
        name = "Fortnite",
        description = "Fortnite é um jogo eletrônico multijogador online e uma plataforma de jogos desenvolvida pela Epic Games e lançada em 2017.",
        imageRes = R.drawable.fortnitelogo,
        items = listOf(
            StoreItem(1, "Skin Iconic", "Fica mais bonito com a recente skin Iconic.", 14.89, R.drawable.icoicfortnite),
            StoreItem(2, "13.500 V-Bucks", "Com todas estas v-bucks compras o passe de batalha e múltiplas skins. ", 13.50, R.drawable.vbucksfortnite),
            StoreItem(3, "Passe de Batalha", "Completa todos os níveis e recebes inumeros prémios, como skins. v-bucks, emotes, picaretas e muito mais!", 9.99, R.drawable.passedebatalhafort)
        )
    ),
    Game(
        id = 2,
        name = "Pokemon",
        description = "Pokémon GO é um jogo eletrônico free-to-play de realidade aumentada voltado para smartphones.",
        imageRes = R.drawable.pokemongo,
        items = listOf(
            StoreItem(4, "100 Pokebolas", "Inumeras pokebolas para puderes caçar os teus pokemons á vontade.", 10.99, R.drawable.pokebolas),
            StoreItem(5, "150 Pokecoins", "Podes comprar várias pokebolas e poções com tantas pokecoins.", 7.99, R.drawable.pokecoins),
            StoreItem(6, "Raid Psss", "Luta nos gináios para capturar pokemons.", 11.49, R.drawable.raidpass)
        )
    )
)


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


@Composable
fun GameListScreen(games: List<Game>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(games) { game ->
            GameCard(
                game = game,
                onClick = {
                    // EM BREVE: Abrir GameDetailActivity
                }
            )
        }
    }
}
