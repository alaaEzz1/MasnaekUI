package com.elmohandes.masnaekscreens.models

data class BuyOrderModel(
    val title: String,
    val orderNo: Int,
    val orderStatus: String,
    val orderValue: Double,
    val orderDate: String,
    val orderVisit: Boolean,
    val orderDelivery: String,
    val orderType: String,
    val orderImage: String,
)
