package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.listeners.ProductsDetailsListener
import com.elmohandes.masnaekscreens.databinding.ProductItemBinding
import com.elmohandes.masnaekscreens.models.ProductModel

class ProductAdapter(
    val products: List<ProductModel>,
    val listener: ProductsDetailsListener
): RecyclerView.Adapter<ProductAdapter.ProductVH>() {
    inner class ProductVH(itemView: View) : ViewHolder(itemView){
        val binding = ProductItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        return ProductVH(LayoutInflater.from(parent.context).inflate(
            R.layout.product_item,parent,false
        ))
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val product = products[position]
        holder.binding.productItemTitle.text = product.title
        holder.binding.productItemPrice.text = "${product.price} SAR"
        Glide.with(holder.itemView.context).load(product.image)
            .into(holder.binding.productItemImage)
        holder.itemView.setOnClickListener {
            listener.onClick(product)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}