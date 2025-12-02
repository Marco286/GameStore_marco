@Composable
fun GameCard(game: Game, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = game.imageRes),
                contentDescription = game.name,
                modifier = Modifier.size(80.dp)
            )
            Spacer(Modifier.width(12.dp))
            Column {
                Text(text = game.name)
                Text(text = game.description, maxLines = 2)
            }
        }
    }
}

//
// -------------------------------------------------------------
// PREVIEW (OBRIGATÓRIO PELO ENUNCIADO)
// -------------------------------------------------------------
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore_marco.R

@Preview(showBackground = true)
@Composable
fun GameCardPreview() {
    val sampleGame = Game(
        id = 1,
        name = "Sky Adventure",
        description = "Preview description...",
        imageRes = R.drawable.ic_launcher_foreground,
        items = emptyList()
    )

    GameCard(game = sampleGame, onClick = {})
}
