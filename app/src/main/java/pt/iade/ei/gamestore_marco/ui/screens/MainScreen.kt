package pt.iade.ei.gamestore_marco.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pt.iade.ei.gamestore_marco.ui.components.BottomBar
import pt.iade.ei.gamestore_marco.model.Game
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme
import pt.iade.ei.gamestore_marco.sampleGames


@Composable
fun MainScreen(games: List<Game>) {

    Scaffold(
        bottomBar = {
            BottomBar()
        }
    ) { padding ->

        Box(modifier = Modifier.padding(padding)) {


            GameListScreen(games)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    GameStore_marcoTheme {
        MainScreen(games = sampleGames)
    }
}
