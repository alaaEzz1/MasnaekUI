package com.elmohandes.masnaekscreens.screens.order_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.BuyOrderPagerAdapter
import com.elmohandes.masnaekscreens.models.BuyOrderModel


class BuyOrderFragment : Fragment() {

    lateinit var rv: RecyclerView
    lateinit var adapter: BuyOrderPagerAdapter
    lateinit var orders: List<BuyOrderModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_buy_order, container, false)

        rv = view.findViewById(R.id.order_buy_rv)

        orders = listOf(
            BuyOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                "buy order",
                ""
            ),
            BuyOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                "buy order",
                ""
            ),
            BuyOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                "buy order",
                ""
            ),
            BuyOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                "buy order",
                ""
            ),
            BuyOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                "buy order",
                ""
            ),
            BuyOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                "buy order",
                ""
            ),
            BuyOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                "buy order",
                ""
            ),
            BuyOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                "buy order",
                ""
            ),
        )
        adapter = BuyOrderPagerAdapter(orders)

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}