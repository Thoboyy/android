package fr.isen.BOUE.androiderestaurant

import java.io.Serializable

data class Details(
    val data : List<Menu>
): Serializable

data class Menu(
    val name_fr: String,
    val name_en : String,
    val items : List<Items>
) : Serializable

data class Items (
    val name_fr : String,
    val images : List<String>,
    val ingredients : List<Ingredients>,
    val prices : ArrayList<Prices>
) : Serializable

data class Prices(
    val price: String
) : Serializable

data class Ingredients(
    val name_fr: String
) : Serializable