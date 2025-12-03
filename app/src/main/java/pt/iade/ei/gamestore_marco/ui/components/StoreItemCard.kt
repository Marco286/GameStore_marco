package pt.iade.ei.gamestore_marco.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import pt.iade.ei.gamestore_marco.model.StoreItem
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.gamestore_marco.R

@Composable
fun StoreItemCard(item: StoreItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // IMAGEM DO ITEM (como na 2ª print do briefing)
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.width(12.dp))

            // NOME + DESCRIÇÃO
            Column(modifier = Modifier.weight(1f)) {
                Text(item.name, style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(4.dp))
                Text(item.description, maxLines = 2)
            }

            // PREÇO À DIREITA
            Text(
                text = "$${item.price}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun StoreItemCardPreview() {
    val sampleItem = StoreItem(
        id = 1,
        name = "Skin Iconic",
        description = "Uma skin muito bonita.",
        price = 14.89,
        imageRes = R.drawable.icoicfortnite
    )

    StoreItemCard(item = sampleItem, onClick = {})
}
