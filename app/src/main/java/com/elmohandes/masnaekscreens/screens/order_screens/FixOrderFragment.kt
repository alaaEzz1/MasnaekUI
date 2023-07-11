package com.elmohandes.masnaekscreens.screens.order_screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.FixOrderPagerAdapter
import com.elmohandes.masnaekscreens.models.FixOrderModel

class FixOrderFragment : Fragment() {

    lateinit var rv: RecyclerView
    lateinit var adapter: FixOrderPagerAdapter
    lateinit var orders: List<FixOrderModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_fix_order, container, false)

        rv = view.findViewById(R.id.fix_order_rv)

        orders = listOf(
            FixOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                ""
            ),
            FixOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                ""
            ),
            FixOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                ""
            ),
            FixOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                ""
            ),
            FixOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                ""
            ),
            FixOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                ""
            ),
            FixOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                ""
            ),
            FixOrderModel(
                "fix Rood door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "Reyad",
                ""
            ),
        )
        adapter = FixOrderPagerAdapter(orders)

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}