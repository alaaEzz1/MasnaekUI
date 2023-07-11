package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.listeners.ProductsDetailsListener
import com.elmohandes.masnaekscreens.databinding.ProductProductsItemBinding
import com.elmohandes.masnaekscreens.models.ProductModel

class ProductProductsAdapter(
    private val products: List<ProductModel>,
    private val listener: ProductsDetailsListener
): RecyclerView.Adapter<ProductProductsAdapter.ProductProductsVH>() {

    inner class ProductProductsVH(itemView: View) : ViewHolder(itemView){
        val binding= ProductProductsItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductProductsVH {
        return ProductProductsVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.product_products_item,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductProductsVH, position: Int) {
        val product = products[position]
        holder.binding.productProductsTitle.text = product.title
        holder.binding.productProductsPrice.text = "${product.price} ريال"
        Glide.with(holder.itemView.context).load(product.image)
            .into(holder.binding.productProductsImg)
        holder.itemView.setOnClickListener {
            listener.onClick(product)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

}