package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.databinding.ManufactureOrderItemBinding
import com.elmohandes.masnaekscreens.models.ManufactureOrderModel

class ManufactureOrderAdapter(
    val orders: List<ManufactureOrderModel>
): RecyclerView.Adapter<ManufactureOrderAdapter.OrderVH>() {

    inner class OrderVH(itemView: View): ViewHolder(itemView){
        val binding = ManufactureOrderItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderVH {
        return OrderVH(LayoutInflater.from(parent.context).inflate(
            R.layout.manufacture_order_item,parent,false
        ))
    }

    override fun onBindViewHolder(holder: OrderVH, position: Int) {
        val order = orders[position]
        holder.binding.orderTitle.text = order.title
        holder.binding.orderDate.text = "Order number ${order.orderNo} with date ${order.orderDate}"
        holder.binding.orderStatus.text = order.orderStatus
        holder.binding.orderValue.text = "Value = ${order.orderValue} SAR"
        holder.binding.orderSizes.text = "Sizes = ${order.orderSizes}"
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}