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
import com.elmohandes.masnaekscreens.adapters.listeners.CategoryListener
import com.elmohandes.masnaekscreens.models.MainCategoryModel

class MainCategoryAdapter(
    private val categories: List<MainCategoryModel>,
    private val listener: CategoryListener
): RecyclerView.Adapter<MainCategoryAdapter.MainCategoryVH>() {

    private var selectedItemPosition = RecyclerView.NO_POSITION

    inner class MainCategoryVH(itemView: View): ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.main_category_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryVH {
        return MainCategoryVH(LayoutInflater.from(parent.context).inflate(
            R.layout.main_category_item,parent,false
        ))
    }

    override fun onBindViewHolder(holder: MainCategoryVH, position: Int) {
        Glide.with(holder.itemView.context).load(categories[position].image)
            .into(holder.image)

        //TODO: Make selection in RecyclerView
        if (position == selectedItemPosition){
            holder.itemView.setBackgroundColor(ContextCompat.getColor(
                holder.itemView.context,R.color.blue_bg
            ))
        }else{
            holder.itemView.setBackgroundColor(ContextCompat.getColor(
                holder.itemView.context,R.color.white
            ))
        }

        holder.itemView.setOnClickListener {
            val clickedPosition = holder.adapterPosition
            if (selectedItemPosition != clickedPosition){
                selectedItemPosition = clickedPosition
                notifyDataSetChanged()
            }

            listener.onClick(categories[position],position)
        }

    }

    override fun getItemCount(): Int {
        return categories.size
    }

}