package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.databinding.FixOrderItemBinding
import com.elmohandes.masnaekscreens.models.FixOrderModel

class FixOrderPagerAdapter(
    val orders: List<FixOrderModel>
) : RecyclerView.Adapter<FixOrderPagerAdapter.FixOrderPagerVH>() {
    inner class FixOrderPagerVH(itemView: View): ViewHolder(itemView){
        val binding = FixOrderItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixOrderPagerVH {
        return FixOrderPagerVH(LayoutInflater.from(parent.context).inflate(
            R.layout.fix_order_item,parent,false
        ))
    }

    override fun onBindViewHolder(holder: FixOrderPagerVH, position: Int) {
        val order = orders[position]
        holder.binding.fixOrderTitle.text = order.title
        holder.binding.fixOrderDate.text = "Order number ${order.orderNo} with date ${order.orderDate}"
        holder.binding.fixOrderStatus.text = order.orderStatus
        holder.binding.fixOrderValue.text = "Value = ${order.orderValue} SAR"
        holder.binding.fixOrderAddress.text = "Address : ${order.orderAddress}"
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}