package pt.iade.ei.gamestore_marco.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import pt.iade.ei.gamestore_marco.R
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore_marco.ui.theme.GameStore_marcoTheme
@Composable
fun BottomBar() {

    NavigationBar(
        containerColor = Color(0xFFF1EAF5)
    ) {

        NavigationBarItem(
            selected = false,
            onClick = { /* não faz nada */ },
            icon = { Icon(painterResource(R.drawable.ic_star), null) },
            label = { Text("Featured") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { /* não faz nada */ },
            icon = { Icon(painterResource(R.drawable.histoty), null) },
            label = { Text("History") }
        )

        NavigationBarItem(
            selected = false,
            onClick = { /* não faz nada */ },
            icon = { Icon(painterResource(R.drawable.ic_profile), null) },
            label = { Text("Profile") }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    GameStore_marcoTheme {
        BottomBar()
    }
}

