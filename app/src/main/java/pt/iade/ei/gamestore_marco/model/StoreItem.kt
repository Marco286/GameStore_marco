package pt.iade.ei.gamestore_marco.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoreItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageRes: Int
) : Parcelable
