package pt.iade.ei.gamestore_marco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import pt.iade.ei.gamestore_marco.model.Game
import pt.iade.ei.gamestore_marco.model.StoreItem
import pt.iade.ei.gamestore_marco.ui.screens.GameListScreen
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme
import pt.iade.ei.gamestore_marco.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore_marco.ui.screens.MainScreen



private val sampleGames = listOf(
    Game(
        id = 1,
        name = "Fortnite",
        description = "Fortnite é um jogo eletrônico multijogador online e uma plataforma de jogos desenvolvida pela Epic Games e lançada em 2017. ",
        imageRes = R.drawable.fortnitelogo,
        items = listOf(
            StoreItem(1, "Skin Iconic", "Skin que te vai deixar com mais estilo nas tuas partidas.", 14.89, R.drawable.icoicfortnite),
            StoreItem(2, "13.500 V-Bucks", "Com tantas V-Bucks podes comprar o que quiseres!", 13.50, R.drawable.vbucksfortnite),
            StoreItem(3, "Passe de Batalha", "Completa todos os níveis e recebe prémios incríveis!", 9.99, R.drawable.passedebatalhafoty)
        )
    ),
    Game(
        id = 2,
        name = "Pokemon GO",
        description = "Pokémon GO é um jogo eletrônico free-to-play de realidade aumentada voltado para smartphones. O jogo é desenvolvido e publicado pela Niantic, Inc., em colaboração com a Nintendo e a The Pokémon Company.",
        imageRes = R.drawable.pokemongo,
        items = listOf(
            StoreItem(4, "100 Pokebolas", "Muitas pokebolas para apanhar pokémons.", 10.99, R.drawable.pokeballs),
            StoreItem(5, "150 Pokecoins", "Moedas para comprar itens na loja.", 7.99, R.drawable.pokecoinss),
            StoreItem(6, "Raid Pass", "Luta nos ginásios e participa em raids especiais.", 11.49, R.drawable.raidpass)
        )
    )
)


class MainActivity : ComponentActivity() {

    companion object {
        const val EXTRA_GAME = "extra_game"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            GameStore_marcoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    MainScreen(games = sampleGames)

                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    GameStore_marcoTheme {
        GameListScreen(
            games = sampleGames
        )
    }
}
