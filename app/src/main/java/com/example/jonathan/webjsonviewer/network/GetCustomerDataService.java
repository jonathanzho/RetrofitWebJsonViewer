package com.example.jonathan.webjsonviewer.network;

import com.example.jonathan.webjsonviewer.model.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCustomerDataService {
  // URL of the web page that contains the Json string to be fetched and displayed:
  String FULL_URL =
      "https://cdn.glitch.com/e2ba5f45-ac8d-4327-b841-0ebbf828878b%2Fgenerated.json?1492577298018";

  @GET(FULL_URL)
  Call<List<Customer>> getCustomerData();
}
