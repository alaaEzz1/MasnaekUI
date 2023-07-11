package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.listeners.CartListener
import com.elmohandes.masnaekscreens.databinding.CartItemBinding
import com.elmohandes.masnaekscreens.models.CartModel

class CartAdapter(
    val carts: List<CartModel>,
    val listener: CartListener
): Adapter<CartAdapter.CartVH>() {
    inner class CartVH(itemView: View) : ViewHolder(itemView){
        val binding = CartItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartVH {
        return CartVH(LayoutInflater.from(parent.context).inflate(
            R.layout.cart_item,parent,false
        ))
    }

    override fun onBindViewHolder(holder: CartVH, position: Int) {
        val cart = carts[position]
        holder.binding.cartItemTitle.text = cart.title
        holder.binding.cartItemPrice.text = "${cart.value} SAR"
        holder.binding.cartItemTotalPrice.text = "${cart.value * cart.quantity}"
        Glide.with(holder.itemView.context).load(cart.image)
            .into(holder.binding.cardItemImg)
        holder.binding.cartItemNumber.text = "${cart.quantity}"
        listener.onChange(carts,position)
        holder.binding.cartItemImgPlus.setOnClickListener {
            cart.quantity = cart.quantity + 1
            holder.binding.cartItemNumber.text = "${cart.quantity}"
            holder.binding.cartItemTotalPrice.text = "${cart.value * cart.quantity}"
            listener.onChange(carts,position)
        }

        holder.binding.cartItemImgMinus.setOnClickListener {
            if (cart.quantity > 0){
                cart.quantity = cart.quantity - 1
                if (cart.quantity == 0){
                    cart.quantity =1
                }
                holder.binding.cartItemNumber.text = "${cart.quantity}"
                holder.binding.cartItemTotalPrice.text = "${cart.value * cart.quantity}"
                listener.onChange(carts,position)
            }
        }
    }

    override fun getItemCount(): Int {
        return carts.size
    }
}