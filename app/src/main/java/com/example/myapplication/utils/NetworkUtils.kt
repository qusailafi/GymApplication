package com.example.myapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import com.example.myapplication.application.MyApp

object NetworkUtils {
    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            MyApp.appContext. getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager?.activeNetworkInfo
        return  activeNetworkInfo!=null

    }
}