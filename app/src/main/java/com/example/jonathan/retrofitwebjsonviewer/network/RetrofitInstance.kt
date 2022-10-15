package com.example.jonathan.retrofitwebjsonviewer.network

import android.util.Log
import retrofit2.Retrofit
import com.example.jonathan.retrofitwebjsonviewer.network.RetrofitInstance
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val TAG = "HWJV " + RetrofitInstance::class.java.simpleName
    private var retrofit: Retrofit? = null

    // Base URL is ignored if full URL is used in the Service's Get methode:
    private const val BASE_URL = "http://BaseUrlIsIgnoredIfFullUrlIsUsedInServiceGetMethod/"
    @JvmStatic
    val retrofitInstance: Retrofit?
        get() {
            Log.d(TAG, "getRetrofitInstance")
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}