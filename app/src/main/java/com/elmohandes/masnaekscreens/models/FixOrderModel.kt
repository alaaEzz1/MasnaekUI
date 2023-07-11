package com.elmohandes.masnaekscreens.models

data class FixOrderModel(
    val title: String,
    val orderNo: Int,
    val orderStatus: String,
    val orderValue: Double,
    val orderDate: String,
    val orderVisit: Boolean,
    val orderAddress: String,
    val orderImage: String,
)