package com.example.jonathan.retrofitwebjsonviewer.adapter

import android.util.Log
import com.example.jonathan.retrofitwebjsonviewer.model.Customer
import androidx.recyclerview.widget.RecyclerView
import com.example.jonathan.retrofitwebjsonviewer.adapter.CustomerAdapter.CustomerViewHolder
import com.example.jonathan.retrofitwebjsonviewer.adapter.CustomerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.jonathan.retrofitwebjsonviewer.R
import android.widget.TextView
import java.util.ArrayList

// After auto conversion from Java to Kotlin, "internal" has to be added:
internal class CustomerAdapter(customerList: ArrayList<Customer>) :
    RecyclerView.Adapter<CustomerViewHolder>() {
    private val mCustomerList: ArrayList<Customer>

    init {
        Log.d(TAG, "CustomerAdapter")
        mCustomerList = customerList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_customer, parent, false)
        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder")
        holder.txtCusName.text = mCustomerList[position].name
        holder.txtCusEmail.text = mCustomerList[position].email
        holder.txtCusBalance.text = mCustomerList[position].balance
        holder.txtCusFriends.text = mCustomerList[position].friends.size.toString()
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: " + mCustomerList.size)
        return mCustomerList.size
    }

    internal class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var TAG = "WJV " + CustomerViewHolder::class.java.simpleName
        val txtCusName: TextView
        val txtCusEmail: TextView
        val txtCusBalance: TextView
        val txtCusFriends: TextView

        init {
            Log.d(TAG, "CustomerViewHolder")
            txtCusName = itemView.findViewById<View>(R.id.txt_customer_name) as TextView
            txtCusEmail = itemView.findViewById<View>(R.id.txt_customer_email) as TextView
            txtCusBalance = itemView.findViewById<View>(R.id.txt_customer_balance) as TextView
            txtCusFriends = itemView.findViewById<View>(R.id.txt_customer_friends) as TextView
        }
    }

    companion object {
        private val TAG = "WJV " + CustomerAdapter::class.java.simpleName
    }
}