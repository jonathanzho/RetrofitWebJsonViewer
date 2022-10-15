package com.example.jonathan.retrofitwebjsonviewer.network

import retrofit2.http.GET
import com.example.jonathan.retrofitwebjsonviewer.network.GetCustomerDataService
import com.example.jonathan.retrofitwebjsonviewer.model.Customer
import retrofit2.Call

interface GetCustomerDataService {
    @get:GET(FULL_URL)
    val customerData: Call<List<Customer?>?>?

    companion object {
        // URL of the web page that contains the Json string to be fetched and displayed:
        const val FULL_URL =
            "https://cdn.glitch.com/e2ba5f45-ac8d-4327-b841-0ebbf828878b%2Fgenerated.json?1492577298018"
    }
}