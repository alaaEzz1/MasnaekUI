package com.elmohandes.masnaekscreens.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.CartAdapter
import com.elmohandes.masnaekscreens.adapters.listeners.CartListener
import com.elmohandes.masnaekscreens.databinding.FragmentCartBinding
import com.elmohandes.masnaekscreens.models.CartModel

class CartFragment : Fragment(), CartListener {

    lateinit var binding: FragmentCartBinding
    lateinit var carts: List<CartModel>
    lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        binding = FragmentCartBinding.bind(view)

        carts = listOf(
            CartModel(
                "chair and table",
                "https://i.pinimg.com/564x/2d/e8/da/2de8da1b3cc6e041f4afa39175c6bb2b.jpg",
                1,
                1000.0
            ),
            CartModel(
                "Home Door",
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                1,
                3000.0
            ),
            CartModel(
                "Bottle Art",
                "https://i.pinimg.com/736x/b7/47/e9/b747e965a410a95e8ce0e5abf5334928.jpg",
                1,
                200.0
            ),
            CartModel(
                "Outdoor Glass",
                "https://i.pinimg.com/564x/9a/ab/a8/9aaba8bb8ada28a9d7a101e51d7b49e9.jpg",
                1,
                1500.0
            ),
            CartModel(
                "Stainless Window",
                "https://i.pinimg.com/564x/88/36/9b/88369b3d17fed65dd5bf52d1312a13d8.jpg",
                1,
                1000.0
            ),
        )

        adapter = CartAdapter(carts,this)
        binding.cartRv.adapter = adapter
        binding.cartRv.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    //TODO: How to calculate total price in cart
    override fun onChange(carts: List<CartModel>, position: Int) {
        var  total = 0.0
        for (price in carts){
            total += price.quantity * price.value
            Log.d("value-quantity", "value = ${price.value} when " +
                    "quantity = ${price.quantity} and total = $total")

        }
        binding.cardTotal.text = "$total SAR"
    }
}