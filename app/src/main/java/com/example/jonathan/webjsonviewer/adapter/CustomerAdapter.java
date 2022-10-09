package com.example.jonathan.webjsonviewer.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jonathan.webjsonviewer.R;
import com.example.jonathan.webjsonviewer.model.Customer;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {
  private static final String TAG = "WJV " + CustomerAdapter.class.getSimpleName();

  private final ArrayList<Customer> mCustomerList;

  public CustomerAdapter(ArrayList<Customer> customerList) {
    Log.d(TAG, "CustomerAdapter");

    mCustomerList = customerList;
  }

  @NonNull
  @org.jetbrains.annotations.NotNull
  @Override
  public CustomerViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
    Log.d(TAG, "onCreateViewHolder");

    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.row_customer, parent, false);
    return new CustomerViewHolder(view);
  }

  @Override
  public void onBindViewHolder(CustomerViewHolder holder, int position) {
    Log.d(TAG, "onBindViewHolder");

    holder.txtCusName.setText(mCustomerList.get(position).getName());
    holder.txtCusEmail.setText(mCustomerList.get(position).getEmail());
    holder.txtCusBalance.setText(mCustomerList.get(position).getBalance());
    holder.txtCusFriends.setText(String.valueOf(mCustomerList.get(position).getFriends().size()));
  }

  @Override
  public int getItemCount() {
    Log.d(TAG, "getItemCount: " + mCustomerList.size());

    return mCustomerList.size();
  }

  static class CustomerViewHolder extends RecyclerView.ViewHolder {
    String TAG = "WJV " + CustomerViewHolder.class.getSimpleName();

    final TextView txtCusName;
    final TextView txtCusEmail;
    final TextView txtCusBalance;
    final TextView txtCusFriends;

    CustomerViewHolder(View itemView) {
      super(itemView);

      Log.d(TAG, "CustomerViewHolder");

      txtCusName = (TextView) itemView.findViewById(R.id.txt_customer_name);
      txtCusEmail = (TextView) itemView.findViewById(R.id.txt_customer_email);
      txtCusBalance = (TextView) itemView.findViewById(R.id.txt_customer_balance);
      txtCusFriends = (TextView) itemView.findViewById(R.id.txt_customer_friends);
    }
  }
}
