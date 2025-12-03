package pt.iade.ei.gamestore_marco.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Game(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
    val items: List<StoreItem>
) : Parcelable

