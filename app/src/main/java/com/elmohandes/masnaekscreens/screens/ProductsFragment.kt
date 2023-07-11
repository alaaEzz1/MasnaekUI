package com.elmohandes.masnaekscreens.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.MainCategoryAdapter
import com.elmohandes.masnaekscreens.adapters.ProductAdapter
import com.elmohandes.masnaekscreens.adapters.ProductProductsAdapter
import com.elmohandes.masnaekscreens.adapters.SubCategoryAdapter
import com.elmohandes.masnaekscreens.adapters.listeners.CategoryListener
import com.elmohandes.masnaekscreens.adapters.listeners.ProductsDetailsListener
import com.elmohandes.masnaekscreens.models.MainCategoryModel
import com.elmohandes.masnaekscreens.models.ProductModel
import com.elmohandes.masnaekscreens.models.SubCategoryModel

class ProductsFragment : Fragment(), ProductsDetailsListener, CategoryListener {

    lateinit var productRV: RecyclerView
    lateinit var categoryRV: RecyclerView
    lateinit var suCategoryRV: RecyclerView
    lateinit var products: List<ProductModel>
    lateinit var productAdapter: ProductProductsAdapter
    lateinit var categoryList:List<MainCategoryModel>
    lateinit var categoryAdapter: MainCategoryAdapter
    lateinit var subCategoryList: List<SubCategoryModel>
    lateinit var subCategoryAdapter: SubCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_products, container, false)
        productRV= view.findViewById(R.id.product_rv)
        categoryRV= view.findViewById(R.id.product_category_rv)
        suCategoryRV = view.findViewById(R.id.product_sub_category_rv)

        suCategoryRV.visibility = View.GONE

        products = listOf(
            ProductModel(
                "باب 2م * 1م",
                200.0,
                "https://i.pinimg.com/originals/f2/46/ce/f246ce620dce4ab1924562e98c3fb305.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "باب زجاج 2م * 1م",
                200.0,
                "https://i.pinimg.com/564x/d9/21/72/d92172681153c71c67b10c6f9bf72c6c.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                1000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),

        )
        categoryList = listOf(
            MainCategoryModel(
                "https://i.pinimg.com/564x/ad/6f/68/ad6f68aa3780157d5adf42bcc0bd9c9b.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/77/45/16/77451635c04184dcb239b89accbf1687.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/a6/10/59/a6105921aa346f84aa4ae78d18498874.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/ee/33/4d/ee334d5380519010f831290210deb949.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/4c/66/ca/4c66ca60c092015d462a066b8dcb0054.jpg",
            ),
            MainCategoryModel(
                "https://i.pinimg.com/564x/62/8f/f5/628ff5a2b9987c739408a7d7646805e6.jpg",
            ),
        )
        subCategoryList = listOf(
            SubCategoryModel(
                R.drawable.door,
                "Aluminum",
                "ابواب"
            ),
            SubCategoryModel(
                R.drawable.window,
                "Aluminum",
                "نوافذ"
            ),
            SubCategoryModel(
                R.drawable.shades,
                "Aluminum",
                "مظلات"
            ),
            SubCategoryModel(
                R.drawable.shutter,
                "Aluminum",
                "شتر"
            ),
            SubCategoryModel(
                R.drawable.washers,
                "Aluminum",
                "مغاسل"
            ),
            SubCategoryModel(
                R.drawable.kitchen,
                "Aluminum",
                "مطابخ"
            ),



        )


        productAdapter = ProductProductsAdapter(products, this)
        productRV.adapter = productAdapter
        productRV.layoutManager = LinearLayoutManager(requireContext())

        //category inflater
        categoryAdapter = MainCategoryAdapter(categoryList, this)
        categoryRV.adapter = categoryAdapter
        categoryRV.layoutManager = LinearLayoutManager(
            requireContext(),RecyclerView.HORIZONTAL,false
        )

        return view
    }

    override fun onClick(productModel: ProductModel) {
        val intent = Intent(requireContext(),ProductDetailsActivity::class.java)
        intent.putExtra("productTitle", productModel.title)
        intent.putExtra("productImage",productModel.image)
        intent.putExtra("productPrice",productModel.price)
        intent.putExtra("productIsAvailable",productModel.isAvailable)
        intent.putExtra("productCategories",productModel.category)
        intent.putExtra("productNotes",productModel.notes)
        intent.putExtra("productRating",productModel.rating)
        requireContext().startActivity(intent)
    }

    override fun onClick(model: MainCategoryModel, position: Int) {

        when{
            position == 4 ->{
                suCategoryRV.visibility = View.VISIBLE
                //subcategory
                subCategoryAdapter = SubCategoryAdapter(subCategoryList)
                suCategoryRV.adapter = subCategoryAdapter
                suCategoryRV.layoutManager = LinearLayoutManager(
                    requireContext(),RecyclerView.HORIZONTAL,false
                )
            }
        }
    }
}