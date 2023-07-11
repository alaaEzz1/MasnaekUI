package com.elmohandes.masnaekscreens.helpers

import android.app.Activity
import android.app.AlertDialog
import com.elmohandes.masnaekscreens.R

class CustomProgressDialog(private val activity: Activity) {

    lateinit var dialog: AlertDialog

    fun startLoading(){
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater

        builder.setView(inflater.inflate(R.layout.custom_progress_dialog,null))
        builder.setCancelable(false)

        dialog = builder.create()
        dialog.show()

    }

    fun dismissDialog(){
        dialog.dismiss()
    }

}