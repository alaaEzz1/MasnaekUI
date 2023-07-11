package com.elmohandes.masnaekscreens.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.databinding.SpinnerItemBinding
import com.elmohandes.masnaekscreens.models.MainCategoryModel

class SpinnerAdapter(
    val categories: List<MainCategoryModel>,
    val context: Context
): BaseAdapter() {
    override fun getCount(): Int {
        return categories.size
    }

    override fun getItem(p0: Int): Any {
        return categories[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.spinner_item, parent, false)
        val model = categories[position]

        val binding: SpinnerItemBinding = SpinnerItemBinding.bind(view)
        Glide.with(context).load(model.image).into(binding.spinnerImg)

        return view
    }

}