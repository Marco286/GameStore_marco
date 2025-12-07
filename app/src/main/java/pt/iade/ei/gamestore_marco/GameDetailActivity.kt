package pt.iade.ei.gamestore_marco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pt.iade.ei.gamestore_marco.model.Game
import pt.iade.ei.gamestore_marco.ui.screens.GameDetailScreen
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore_marco.R
import pt.iade.ei.gamestore_marco.model.StoreItem



class GameDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()


        val game = intent.getParcelableExtra<Game>(MainActivity.EXTRA_GAME)


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
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameDetailActivityPreview() {
    GameStore_marcoTheme {
        GameDetailScreen(
            game = Game(
                id = 1,
                name = "Fortnite",
                description = "Fortnite é um jogo eletrônico multijogador online e uma plataforma de jogos desenvolvida pela Epic Games e lançada em 2017.",
                imageRes = R.drawable.fortnitelogo,
                items = listOf(
                    StoreItem(
                        id = 1,
                        name = "Skin Iconic",
                        description = "Skin que te vai deixar com mais estilo nas tuas partidas.",
                        price = 14.89,
                        imageRes = R.drawable.icoicfortnite
                    ),
                    StoreItem(
                        id = 2,
                        name = "13.500 V-Bucks",
                        description = "Com tantas V-Bucks podes comprar o que quiseres!",
                        price = 13.50,
                        imageRes = R.drawable.vbucksfortnite
                    ),
                    StoreItem(
                        id = 3,
                        name = "Passe de Batalha",
                        description = "Completa todos os níveis e recebe prémios incríveis!",
                        price = 9.99,
                        imageRes = R.drawable.passedebatalhafoty
                    )
                )
            )
        )
    }
}


