package com.elmohandes.masnaekscreens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.databinding.BuyOrderItemBinding
import com.elmohandes.masnaekscreens.models.BuyOrderModel

class BuyOrderPagerAdapter(
    val orders: List<BuyOrderModel>
): RecyclerView.Adapter<BuyOrderPagerAdapter.BuyOrderPagerVH>() {

    inner class BuyOrderPagerVH(itemView: View): ViewHolder(itemView){
        val binding = BuyOrderItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyOrderPagerVH {
        return BuyOrderPagerVH(LayoutInflater.from(parent.context).inflate(
            R.layout.buy_order_item, parent, false
        ))
    }

    override fun onBindViewHolder(holder: BuyOrderPagerVH, position: Int) {
        val order = orders[position]
        holder.binding.buyOrderTitle.text = order.title
        holder.binding.buyOrderDate.text = "Order number ${order.orderNo} with date ${order.orderDate}"
        holder.binding.buyOrderStatus.text = order.orderStatus
        holder.binding.buyOrderValue.text = "Value = ${order.orderValue} SAR"
        holder.binding.buyOrderDelivery.text = "Delivery : ${order.orderDelivery}"
        holder.binding.buyOrderType.text = order.orderType
    }

    override fun getItemCount(): Int {
        return orders.size
    }

}