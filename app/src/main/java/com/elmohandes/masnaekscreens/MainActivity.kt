package com.elmohandes.masnaekscreens

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.elmohandes.masnaekscreens.helpers.CustomProgressDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var cartBtn: FloatingActionButton
    lateinit var homeBtn: LinearLayout
    lateinit var productBtn: LinearLayout
    lateinit var profileBtn: LinearLayout
    lateinit var orderBtn: LinearLayout
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cartBtn = findViewById(R.id.main_btn_add_to_cart)
        homeBtn = findViewById(R.id.main_appbar_home)
        productBtn = findViewById(R.id.main_appbar_product)
        profileBtn = findViewById(R.id.main_appbar_profile)
        orderBtn = findViewById(R.id.main_appbar_order)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host)
                as NavHostFragment
        navController = navHostFragment.navController

        supportActionBar!!.hide()

        setupActions()

    }
    @RequiresApi(Build.VERSION_CODES.P)
    private fun setupActions() {
        val loading = CustomProgressDialog(this@MainActivity)
        homeBtn.setOnClickListener {
            loading.startLoading()
            Handler.createAsync(Looper.myLooper()!!).postDelayed({
                loading.dismissDialog()
                navController.navigateUp()
                navController.navigate(R.id.homeFragment)

            },1000)
        }

        productBtn.setOnClickListener {
            loading.startLoading()
            Handler.createAsync(Looper.myLooper()!!).postDelayed({
                loading.dismissDialog()
                navController.navigateUp()
                navController.navigate(R.id.productsFragment)
            },1000)
        }

        profileBtn.setOnClickListener {
            loading.startLoading()
            Handler.createAsync(Looper.myLooper()!!).postDelayed({
                loading.dismissDialog()
                navController.navigateUp()
                navController.navigate(R.id.profileFragment)
            },1000)
        }

        orderBtn.setOnClickListener {
            loading.startLoading()
            Handler.createAsync(Looper.myLooper()!!).postDelayed({
                loading.dismissDialog()
                navController.navigateUp()
                navController.navigate(R.id.ordersFragment)
            },1000)
        }

        cartBtn.setOnClickListener {
            loading.startLoading()
            Handler.createAsync(Looper.myLooper()!!).postDelayed({
                loading.dismissDialog()
                navController.navigateUp()
                navController.navigate(R.id.cartFragment)
            },1000)
        }

    }
}