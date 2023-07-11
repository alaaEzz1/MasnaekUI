package com.elmohandes.masnaekscreens.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.OuterPagerAdapter
import com.elmohandes.masnaekscreens.databinding.FragmentOrdersBinding
import com.google.android.material.tabs.TabLayoutMediator


class OrdersFragment : Fragment() {

    lateinit var binding: FragmentOrdersBinding
    lateinit var outerAdapter: OuterPagerAdapter
    val outerTapsArray = arrayOf("manufacture","fix orders","Buy orders")
    //val innerTapsArray = arrayOf("New","Current","Last")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_orders, container, false)

        binding = FragmentOrdersBinding.bind(view)

        outerAdapter = OuterPagerAdapter(
            requireActivity().supportFragmentManager,
            requireActivity().lifecycle
        )

        binding.orderViewPager.adapter = outerAdapter

        TabLayoutMediator(binding.orderOuterTabLayout, binding.orderViewPager) { tab, position ->
            tab.text = outerTapsArray[position]
        }.attach()

        return view
    }
}