package com.elmohandes.masnaekscreens.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import com.bumptech.glide.Glide
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.ProductSizesAdapter
import com.elmohandes.masnaekscreens.databinding.ActivityProductDetailsBinding
import com.elmohandes.masnaekscreens.models.ProductSizesModel

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var sizes:List<ProductSizesModel>
    lateinit var adapter: ProductSizesAdapter
    lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val image = intent.getStringExtra("productImage")
        val title = intent.getStringExtra("productTitle")

        sizes = listOf(
            ProductSizesModel(150,300),
            ProductSizesModel(600,200),
            ProductSizesModel(400,500),
            ProductSizesModel(320,300),
            ProductSizesModel(200,150),
        )
        adapter = ProductSizesAdapter(sizes,applicationContext)
        binding.productDetailsSizeSpinner.adapter = adapter

        //TODO: get updated value from spinner and change it in textview
        binding.productDetailsSizeSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val value: ProductSizesModel = parent?.getItemAtPosition(position)
                            as ProductSizesModel
                    //update textview
                    showPriceChang(value)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }

        Glide.with(applicationContext).load(image).into(binding.productDetailsImg)
        binding.productDetailsTitle.text = "$title"

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

    }

    private fun showPriceChang(value: ProductSizesModel) {
        if (value.width == 150 && value.height == 300){
            binding.productDetailsPrice.text = "السعر : 250 ريال"
        }else if (value.width == 600 && value.height == 200){
            binding.productDetailsPrice.text = "السعر : 375 ريال"
        }else if (value.width == 400 && value.height == 500){
            binding.productDetailsPrice.text = "السعر : 400 ريال"
        }else if (value.width == 320 && value.height == 300){
            binding.productDetailsPrice.text = "السعر : 350 ريال"
        }else {
            binding.productDetailsPrice.text = "السعر : 180 ريال"
        }
    }
}