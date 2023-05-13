package com.example.myapplication.network

import com.example.myapplication.model.VendorDetails
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

 @GET("vendor-details?id=127&lang=en&user_id=")
 fun getVendorDetails(): Call<VendorDetails>
}