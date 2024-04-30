package com.example.jetpackcomposeproject.network


import com.example.jetpackcomposeproject.ui.dashboard.AllServicesRequestModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitBuilder {


    //lazy: define heavy variable as lazy to execute it when call it only

    private val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://40.115.6.93:8111/api/")   // Replace with the actual API base URL  // base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }


    suspend fun callGetAllServicesApi(auth : String ,language: String, villaId : String) =
      apiService.getAllServices(auth,language, villaId)

}


