package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.models.MainSliderModel

class MainSliderAdapter(
    private val images :List<MainSliderModel>
): RecyclerView.Adapter<MainSliderAdapter.MainSliderVH>() {

    inner class MainSliderVH(itemView: View) : ViewHolder(itemView) {
        val imageUrl: ImageView = itemView.findViewById(R.id.pager_img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainSliderVH {
        return MainSliderVH(LayoutInflater.from(parent.context)
            .inflate(R.layout.main_slider_item,parent,false))
    }

    override fun onBindViewHolder(holder: MainSliderVH, position: Int) {
        Glide.with(holder.itemView.context).load(images[position].imageUrl)
            .into(holder.imageUrl)
    }

    override fun getItemCount(): Int {
        return images.size
    }

}