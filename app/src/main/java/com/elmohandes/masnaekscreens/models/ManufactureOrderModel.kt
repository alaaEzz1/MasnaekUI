package com.elmohandes.masnaekscreens.models

data class ManufactureOrderModel(
    val title: String,
    val orderNo: Int,
    val orderStatus: String,
    val orderValue: Double,
    val orderDate: String,
    val orderVisit: Boolean,
    val orderSizes: String,
    val orderImage: String,
)
