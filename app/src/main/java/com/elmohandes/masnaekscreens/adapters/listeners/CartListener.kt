package com.elmohandes.masnaekscreens.adapters.listeners

import com.elmohandes.masnaekscreens.models.CartModel

interface CartListener {
    fun onChange(carts: List<CartModel>, position: Int)
}