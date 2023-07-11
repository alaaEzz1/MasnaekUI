package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.databinding.BestTradersItemBinding
import com.elmohandes.masnaekscreens.models.BestTradersModel

class BestTradersAdapter(
    val traders: List<BestTradersModel>
): RecyclerView.Adapter<BestTradersAdapter.BestTradersVH>() {

    inner class BestTradersVH(itemView: View) : ViewHolder(itemView){
        val binding= BestTradersItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestTradersVH {
        return BestTradersVH(LayoutInflater.from(parent.context).inflate(
            R.layout.best_traders_item,parent,false
        ))
    }

    override fun onBindViewHolder(holder: BestTradersVH, position: Int) {
        Glide.with(holder.itemView.context).load(traders[position].image)
            .into(holder.binding.bestTraderImg)
    }

    override fun getItemCount(): Int {
        return traders.size
    }

}