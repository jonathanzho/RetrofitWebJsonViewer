package com.example.jonathan.webjsonviewer.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jonathan.webjsonviewer.R;
import com.example.jonathan.webjsonviewer.adapter.CustomerAdapter;
import com.example.jonathan.webjsonviewer.model.Customer;
import com.example.jonathan.webjsonviewer.network.GetCustomerDataService;
import com.example.jonathan.webjsonviewer.network.RetrofitInstance;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "WJV " + MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Create handle for the RetrofitInstance interface
    GetCustomerDataService service = RetrofitInstance.getRetrofitInstance().create(GetCustomerDataService.class);

    // Call the method with parameter in the interface to get the Customer data
    Call<List<Customer>> call = service.getCustomerData();

    Log.v(TAG, "onCreate: request URL=[" + call.request().url() + "]");

    call.enqueue(new Callback<List<Customer>>() {
      @Override
      public void onResponse(@NotNull Call<List<Customer>> call,
                             @NotNull Response<List<Customer>> response) {
        Log.v(TAG, "CallListCustomer: onResponse");

        generateCustomerList((ArrayList<Customer>) response.body());
      }

      @Override
      public void onFailure(@NotNull Call<List<Customer>> call, @NotNull Throwable t) {
        Log.e(TAG, "CallListCustomer: onFailure. Check Internet.");
      }
    });
  }

  // Method to generate List of Customers using RecyclerView with custom adapter
  private void generateCustomerList(ArrayList<Customer> cusDataList) {
    Log.d(TAG, "generateCustomerList");

    RecyclerView recyclerView =
        (RecyclerView) findViewById(R.id.recycler_view_customer_list);

    CustomerAdapter adapter = new CustomerAdapter(cusDataList);

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

    recyclerView.setLayoutManager(layoutManager);

    recyclerView.setAdapter(adapter);
  }

  @Override
  protected void onStart() {
    Log.d(TAG, "onStart");
    super.onStart();
  }

  @Override
  protected void onResume() {
    Log.d(TAG, "onResume");
    super.onResume();
  }

  @Override
  protected void onPause() {
    Log.d(TAG, "onPause");
    super.onPause();
  }

  @Override
  protected void onStop() {
    Log.d(TAG, "onStop");
    super.onStop();
  }

  @Override
  protected void onDestroy() {
    Log.d(TAG, "onDestroy");
    super.onDestroy();
  }
}