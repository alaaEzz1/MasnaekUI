package com.elmohandes.masnaekscreens.adapters.listeners

import com.elmohandes.masnaekscreens.models.MainCategoryModel

interface CategoryListener {
    fun onClick(model: MainCategoryModel, position: Int)
}