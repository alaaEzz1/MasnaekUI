package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.models.BestTradersModel
import com.elmohandes.masnaekscreens.models.MainSliderModel

class TraderSliderAdapter(
    private val images :List<BestTradersModel>
): RecyclerView.Adapter<TraderSliderAdapter.TraderSliderVH>() {

    inner class TraderSliderVH(itemView: View) : ViewHolder(itemView) {
        val imageUrl: ImageView = itemView.findViewById(R.id.trader_slider_img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraderSliderVH {
        return TraderSliderVH(LayoutInflater.from(parent.context)
            .inflate(R.layout.trader_slider_item,parent,false))
    }

    override fun onBindViewHolder(holder: TraderSliderVH, position: Int) {
        Glide.with(holder.itemView.context).load(images[position].image)
            .into(holder.imageUrl)
    }

    override fun getItemCount(): Int {
        return images.size
    }

}