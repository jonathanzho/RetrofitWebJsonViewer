package com.example.jonathan.retrofitwebjsonviewer.ui

import com.example.jonathan.retrofitwebjsonviewer.network.RetrofitInstance.retrofitInstance
//JZ import com.example.jonathan.retrofitwebjsonviewer.network.GetCustomerDataService.customerData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.jonathan.retrofitwebjsonviewer.ui.MainActivity
import com.example.jonathan.retrofitwebjsonviewer.R
import com.example.jonathan.retrofitwebjsonviewer.network.GetCustomerDataService
import com.example.jonathan.retrofitwebjsonviewer.network.RetrofitInstance
import com.example.jonathan.retrofitwebjsonviewer.model.Customer
import androidx.recyclerview.widget.RecyclerView
import com.example.jonathan.retrofitwebjsonviewer.adapter.CustomerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create handle for the RetrofitInstance interface
        val service = retrofitInstance!!.create(
            GetCustomerDataService::class.java
        )

        // Call the method with parameter in the interface to get the Customer data
        val call = service.customerData
        Log.v(TAG, "onCreate: request URL=[" + call!!.request().url() + "]")
        call.enqueue(object : Callback<List<Customer?>?> {
            override fun onResponse(
                call: Call<List<Customer?>?>,
                response: Response<List<Customer?>?>
            ) {
                Log.v(TAG, "CallListCustomer: onResponse")
                //JZ generateCustomerList(response.body() as ArrayList<Customer?>?)
                generateCustomerList(response.body() as ArrayList<Customer>)
            }

            override fun onFailure(call: Call<List<Customer?>?>, t: Throwable) {
                Log.e(TAG, "CallListCustomer: onFailure. Check Internet.")
            }
        })
    }

    // Method to generate List of Customers using RecyclerView with custom adapter
    //JZ private fun generateCustomerList(cusDataList: ArrayList<Customer?>?) {
    private fun generateCustomerList(cusDataList: ArrayList<Customer>) {
        Log.d(TAG, "generateCustomerList")
        val recyclerView = findViewById<View>(R.id.recycler_view_customer_list) as RecyclerView
        val adapter = CustomerAdapter(cusDataList)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    companion object {
        private val TAG = "WJV " + MainActivity::class.java.simpleName
    }
}