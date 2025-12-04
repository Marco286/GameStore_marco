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
@Preview(showBackground = true)
@Composable
fun GameDetailActivityPreview() {
    GameStore_marcoTheme {
        GameDetailScreen(
            game = Game(
                id = 99,
                name = "Preview Game",
                description = "Descrição de teste apenas para preview.",
                imageRes = R.drawable.fortnitelogo,
                items = emptyList()
            )
        )
    }
}
