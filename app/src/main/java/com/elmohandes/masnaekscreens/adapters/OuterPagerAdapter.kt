package com.elmohandes.masnaekscreens.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.elmohandes.masnaekscreens.screens.order_screens.BuyOrderFragment
import com.elmohandes.masnaekscreens.screens.order_screens.FixOrderFragment
import com.elmohandes.masnaekscreens.screens.order_screens.NewOrderFragment


class OuterPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    val taps: Int = 3


    override fun getItemCount(): Int {
        return taps
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return NewOrderFragment()
            1 -> return FixOrderFragment()
            2 -> return BuyOrderFragment()
        }
        return NewOrderFragment()
    }

}