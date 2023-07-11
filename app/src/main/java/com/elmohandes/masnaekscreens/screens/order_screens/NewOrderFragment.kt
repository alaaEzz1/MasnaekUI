package com.elmohandes.masnaekscreens.screens.order_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.ManufactureOrderAdapter
import com.elmohandes.masnaekscreens.models.ManufactureOrderModel


class NewOrderFragment : Fragment() {

    lateinit var rv: RecyclerView
    lateinit var adapter: ManufactureOrderAdapter
    lateinit var orders: List<ManufactureOrderModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new_order, container, false)

        rv = view.findViewById(R.id.order_new_rv)

        orders = listOf(
            ManufactureOrderModel(
                "door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "180 x 50",
                ""
            ),
            ManufactureOrderModel(
                "door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "180 x 50",
                ""
            ),
            ManufactureOrderModel(
                "door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "180 x 50",
                ""
            ),
            ManufactureOrderModel(
                "door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "180 x 50",
                ""
            ),
            ManufactureOrderModel(
                "door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "180 x 50",
                ""
            ),
            ManufactureOrderModel(
                "door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "180 x 50",
                ""
            ),
            ManufactureOrderModel(
                "door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "180 x 50",
                ""
            ),
            ManufactureOrderModel(
                "door for the outer home",
                11,
                "pending",
                300.0,
                "13:22 10-03-2022",
                false,
                "180 x 50",
                ""
            ),
        )
        adapter = ManufactureOrderAdapter(orders)

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}