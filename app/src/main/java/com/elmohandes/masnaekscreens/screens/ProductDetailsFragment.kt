package com.elmohandes.masnaekscreens.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.ProductSizesAdapter
import com.elmohandes.masnaekscreens.databinding.FragmentProductDetailsBinding
import com.elmohandes.masnaekscreens.models.ProductSizesModel

class ProductDetailsFragment : Fragment() {
    lateinit var binding: FragmentProductDetailsBinding
    lateinit var sizes:List<ProductSizesModel>
    lateinit var adapter: ProductSizesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product_details, container, false)
        binding = FragmentProductDetailsBinding.bind(view)

        sizes = listOf(
            ProductSizesModel(150,300),
            ProductSizesModel(600,200),
            ProductSizesModel(400,500),
            ProductSizesModel(320,300),
            ProductSizesModel(200,150),
        )
        adapter = ProductSizesAdapter(sizes,requireContext())

        Glide.with(requireActivity().applicationContext)
            .load("https://i.pinimg.com/564x/3f/87/fd/3f87fdfa16be7c12e555e97551ae7567.jpg")
            .into(binding.productDetailsImg)

        var result = 0;
        binding.productDetailsPlus.setOnClickListener {
            result++
            binding.productDetailsResult.text = "$result"
        }

        binding.productDetailsMinus.setOnClickListener {
            if (result > 1){
                result --
                binding.productDetailsResult.text = "$result"
            }
        }

        binding.productDetailsSizeSpinner.adapter = adapter

        return view
    }

}