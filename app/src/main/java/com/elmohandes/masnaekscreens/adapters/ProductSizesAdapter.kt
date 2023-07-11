package com.elmohandes.masnaekscreens.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.models.ProductSizesModel

class ProductSizesAdapter(
    val sizes: List<ProductSizesModel>,
    val context: Context
) : BaseAdapter() {
    override fun getCount(): Int {
        return sizes.size
    }

    override fun getItem(position: Int): Any {
        return sizes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.text_spinner_item, parent, false)

        val model = sizes[position]
        val sizeText: TextView = view.findViewById(R.id.spinner_size)
        sizeText.text = "${model.width} X ${model.height}"

        return view
    }


}