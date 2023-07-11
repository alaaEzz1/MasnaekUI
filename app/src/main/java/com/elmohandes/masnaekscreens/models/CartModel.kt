package com.elmohandes.masnaekscreens.models

data class CartModel(
    val title: String,
    val image: String,
    var quantity: Int = 1,
    val value: Double,
)
