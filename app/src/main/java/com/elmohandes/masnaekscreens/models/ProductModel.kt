package com.elmohandes.masnaekscreens.models

data class ProductModel(
    val title: String,
    val price: Double,
    val image: String,
    val isAvailable: Boolean,
    val rating: Double,
    val category: String,
    val notes: String,
)
