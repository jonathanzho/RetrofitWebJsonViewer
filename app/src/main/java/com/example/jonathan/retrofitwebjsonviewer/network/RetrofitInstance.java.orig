package com.example.jonathan.retrofitwebjsonviewer.network;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
  private static final String TAG = "WJV " + RetrofitInstance.class.getSimpleName();

  private static Retrofit retrofit;

  // Base URL is ignored if full URL is used in the Service's Get methode:
  private static final String BASE_URL =
      "http://BaseUrlIsIgnoredIfFullUrlIsUsedInServiceGetMethod/";

  public static Retrofit getRetrofitInstance() {
    Log.d(TAG, "getRetrofitInstance");

    if (retrofit == null) {
      retrofit = new retrofit2.Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }

    return retrofit;
  }
}
