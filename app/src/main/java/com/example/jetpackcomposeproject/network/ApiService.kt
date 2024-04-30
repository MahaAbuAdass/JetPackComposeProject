package com.example.jetpackcomposeproject.network

import com.example.jetpackcomposeproject.ui.dashboard.ServicesResponseModel
import org.intellij.lang.annotations.Language
import retrofit2.http.GET
import retrofit2.http.Header


interface ApiService {

    @GET("Services/GetAllServices")
    suspend fun getAllServices(
        @Header("Authorization") auth: String? ,
        @Header("Accept-Language") language: String? ,
        @Header("VillaId") villaId: String?

    ): ServicesResponseModel


}