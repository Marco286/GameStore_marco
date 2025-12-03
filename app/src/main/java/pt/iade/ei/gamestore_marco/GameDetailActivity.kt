package pt.iade.ei.gamestore_marco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import pt.iade.ei.gamestore_marco.model.Game
import pt.iade.ei.gamestore_marco.ui.screens.GameDetailScreen
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme

class GameDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // Recebe o jogo da MainActivity
        val game = intent.getParcelableExtra<Game>(MainActivity.EXTRA_GAME)

        // Se não existir, fecha a Activity
        if (game == null) {
            finish()
            return
        }

        // Mostra o ecrã de detalhes usando Compose
        setContent {
            GameStore_marcoTheme {
                GameDetailScreen(game = game)
            }
        }
    }
}
