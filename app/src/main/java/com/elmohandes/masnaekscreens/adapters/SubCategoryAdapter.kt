package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.models.SubCategoryModel

class SubCategoryAdapter(
    private val images: List<SubCategoryModel>,
): RecyclerView.Adapter<SubCategoryAdapter.SubCategoryVH>() {

    private var selectedItemPosition = RecyclerView.NO_POSITION

    inner class SubCategoryVH(itemView: View) : ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.sub_category_image)
        val title: TextView = itemView.findViewById(R.id.sub_category_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryVH {
        return SubCategoryVH(LayoutInflater.from(parent.context).inflate(
            R.layout.sub_category_item,parent,false
        ))
    }

    override fun onBindViewHolder(holder: SubCategoryVH, position: Int) {
        holder.image.setImageResource(images[position].image)
        holder.title.text = images[position].title
    }

    override fun getItemCount(): Int {
        return images.size
    }
}