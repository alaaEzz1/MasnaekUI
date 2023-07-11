package com.elmohandes.masnaekscreens.screens

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elmohandes.masnaekscreens.R
import com.elmohandes.masnaekscreens.adapters.MainCategoryAdapter
import com.elmohandes.masnaekscreens.adapters.MainSliderAdapter
import com.elmohandes.masnaekscreens.adapters.ProductAdapter
import com.elmohandes.masnaekscreens.adapters.TraderSliderAdapter
import com.elmohandes.masnaekscreens.adapters.listeners.CategoryListener
import com.elmohandes.masnaekscreens.adapters.listeners.ProductsDetailsListener
import com.elmohandes.masnaekscreens.databinding.FragmentHomeBinding
import com.elmohandes.masnaekscreens.models.BestTradersModel
import com.elmohandes.masnaekscreens.models.MainCategoryModel
import com.elmohandes.masnaekscreens.models.MainSliderModel
import com.elmohandes.masnaekscreens.models.ProductModel
import java.util.*


class HomeFragment : Fragment(), ProductsDetailsListener, CategoryListener {

    lateinit var binding: FragmentHomeBinding
    lateinit var images: List<MainSliderModel>
    lateinit var sliderAdapter:MainSliderAdapter
    lateinit var timer:Timer
    lateinit var traderTimer: Timer
    lateinit var categoryList:List<MainCategoryModel>
    lateinit var categoryAdapter: MainCategoryAdapter
    lateinit var bestDeals: List<ProductModel>
    lateinit var bestSeller: List<ProductModel>
    lateinit var bestAccessories: List<ProductModel>
    lateinit var productAdapter: ProductAdapter
    lateinit var bestSellerAdapter: ProductAdapter
    lateinit var accessoriesProductAdapter: ProductAdapter
    lateinit var bestTraders: List<BestTradersModel>
    lateinit var bestTradersAdapter: TraderSliderAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)

        images = listOf(
            MainSliderModel(
                "https://i.pinimg.com/564x/56/4c/b3/564cb380b1031b16199c2e3b8627d954.jpg"
            ),
            MainSliderModel(
                "https://i.pinimg.com/564x/fd/8a/0d/fd8a0d2f9d4554c24debbf2912833341.jpg"
            ),
            MainSliderModel(
                "https://i.pinimg.com/564x/56/4c/b3/564cb380b1031b16199c2e3b8627d954.jpg"
            ),

            MainSliderModel(
                "https://i.pinimg.com/564x/3c/57/46/3c57461024262176d2572dc015e5d6b7.jpg"
            ),
            MainSliderModel(
                "https://i.pinimg.com/564x/c4/3f/45/c43f4514ba7b37853d2ffb5f8dfb39e4.jpg"
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
        bestDeals = listOf(
            ProductModel(
                "Stainless Window",
                1000.0,
                "https://i.pinimg.com/564x/88/36/9b/88369b3d17fed65dd5bf52d1312a13d8.jpg",
                true,
                5.0,
                "stainless",
                "No Notes"
            ),
            ProductModel(
                "Bed",
                1000.0,
                "https://i.pinimg.com/564x/69/e4/2a/69e42ae840eabd6230034f402e4594a0.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "chair and table",
                1000.0,
                "https://i.pinimg.com/564x/2d/e8/da/2de8da1b3cc6e041f4afa39175c6bb2b.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "Home Door",
                3000.0,
                "https://i.pinimg.com/564x/55/fd/e2/55fde2c67d7ef21a9bc78cae9c2eff39.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
        )
        bestSeller = listOf(
            ProductModel(
                "Outdoor Glass",
                1500.0,
                "https://i.pinimg.com/564x/9a/ab/a8/9aaba8bb8ada28a9d7a101e51d7b49e9.jpg",
                true,
                5.0,
                "stainless",
                "No Notes"
            ),
            ProductModel(
                "Bottle Art",
                200.0,
                "https://i.pinimg.com/736x/b7/47/e9/b747e965a410a95e8ce0e5abf5334928.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "chair and table",
                1000.0,
                "https://i.pinimg.com/564x/2d/e8/da/2de8da1b3cc6e041f4afa39175c6bb2b.jpg",
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
        bestAccessories = listOf(
            ProductModel(
                "Door Handle",
                1000.0,
                "https://i.pinimg.com/736x/37/6c/3b/376c3b1a97926ee5b547eb24a35562ac.jpg",
                true,
                5.0,
                "Accessories",
                "No Notes"
            ),
            ProductModel(
                "Faux flower",
                300.0,
                "https://i.pinimg.com/564x/0f/9c/c3/0f9cc3b53c5955a6a9c9dcc895f761f8.jpg",
                true,
                5.0,
                "Accessories",
                "No Notes"
            ),
            ProductModel(
                "Silver Romano",
                400.0,
                "https://i.pinimg.com/564x/68/9e/6e/689e6eef76d059d14da7326ede3af522.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
            ProductModel(
                "indoor plants",
                1000.0,
                "https://i.pinimg.com/564x/c4/c5/cf/c4c5cf899cfc0600c564c6245f4dcb25.jpg",
                true,
                5.0,
                "wood",
                "No Notes"
            ),
        )
        bestTraders = listOf(
            BestTradersModel(
                "https://i.pinimg.com/564x/f3/2a/9b/f32a9b71e63a30191496d2ef28a2970e.jpg",
            ),
            BestTradersModel(
                "https://i.pinimg.com/736x/e8/d7/ce/e8d7ce70bd00230adcc867fd37a25744.jpg",
            ),
            BestTradersModel(
                "https://i.pinimg.com/564x/53/f5/82/53f582309ef61da372e1998b944d5418.jpg",
            ),
            BestTradersModel(
                "https://i.pinimg.com/736x/6e/48/08/6e480824e8e85f881ac47f8cb0bb868c.jpg",
            ),
            BestTradersModel(
                "https://i.pinimg.com/736x/d8/2d/6c/d82d6cc9649ab5612dc7bf775f65e002.jpg",
            ),
            BestTradersModel(
                "https://i.pinimg.com/736x/86/af/a0/86afa0b03226f5c285d6deab4acd76f0.jpg",
            ),
        )

        //home top slider
        sliderAdapter = MainSliderAdapter(images)
        binding.mainPagerBanner.adapter = sliderAdapter

        val handler = Handler(Looper.getMainLooper())
        val update = Runnable {
            val currentItem = binding.mainPagerBanner.currentItem
            val nextItem = if(currentItem == sliderAdapter.itemCount - 1) 0 else currentItem + 1
            binding.mainPagerBanner.setCurrentItem(nextItem, true)
        }

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 5000, 5000) // advance every 5 seconds

        //categories inflate
        categoryAdapter = MainCategoryAdapter(categoryList,this)
        binding.mainCategoryRv.adapter = categoryAdapter
        binding.mainCategoryRv.layoutManager = LinearLayoutManager(
            requireContext(),RecyclerView.HORIZONTAL,false
        )

        //best deals inflate
        productAdapter = ProductAdapter(bestDeals,this)
        binding.mainBestDealsRv.adapter = productAdapter
        binding.mainBestDealsRv.layoutManager = LinearLayoutManager(
            requireContext(),RecyclerView.HORIZONTAL,false
        )

        //best accessories inflate
        accessoriesProductAdapter = ProductAdapter(bestAccessories,this)
        binding.mainBestAccessoriesRv.adapter = accessoriesProductAdapter
        binding.mainBestAccessoriesRv.layoutManager = LinearLayoutManager(
            requireContext(),RecyclerView.HORIZONTAL,false
        )

        //best seller inflate
        bestSellerAdapter = ProductAdapter(bestSeller,this)
        binding.mainBestSellerRv.adapter = bestSellerAdapter
        binding.mainBestSellerRv.layoutManager = LinearLayoutManager(
            requireContext(),RecyclerView.HORIZONTAL,false
        )

        //trader pager
        bestTradersAdapter = TraderSliderAdapter(bestTraders)
        binding.mainPagerTraderBanner.adapter = bestTradersAdapter

        val traderHandler = Handler()
        val traderUpdate = Runnable {
            val currentItem = binding.mainPagerTraderBanner.currentItem
            val nextItem =if(currentItem == bestTradersAdapter.itemCount-1) 0 else currentItem + 1
            binding.mainPagerTraderBanner.setCurrentItem(nextItem, true)
        }

        traderTimer = Timer()
        traderTimer.schedule(object : TimerTask() {
            override fun run() {
                traderHandler.post(traderUpdate)
            }
        }, 5000, 5000)


        binding.mainBtnManufacture.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_home_to_manufactureRequest
            )
        }

        binding.mainBtnFix.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(
                R.id.action_home_to_fixRequest
            )
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()

        timer.cancel()
    }

    override fun onClick(productModel: ProductModel) {
        val bundle = bundleOf(
            "productTitle" to productModel.title,
            "productImage" to productModel.image,
            "productPrice" to productModel.price,
            "productIsAvailable" to productModel.isAvailable,
            "productCategories" to productModel.category,
            "productNotes" to productModel.notes,
            "productRating" to productModel.rating,
        )
        Navigation.findNavController(requireView())
            .navigate(R.id.action_home_to_productDetails,bundle)
    }

    override fun onClick(model: MainCategoryModel, position: Int) {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_homeFragment_to_productsFragment)
    }
}