package com.example.jetpackcomposeproject.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeproject.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val retrofitBuilder = RetrofitBuilder()

    private val _getAllServiceResponseModel = MutableStateFlow<List<ServicesDataModel>?>(null)
    val getAllServiceResponseModel: StateFlow<List<ServicesDataModel>?> = _getAllServiceResponseModel

    private val _errorResponse = MutableStateFlow<BaseError?>(null)
    val errorResponse: StateFlow<BaseError?> = _errorResponse

    suspend fun getAllServices(auth: String, language: String, villaId: String) {

        val response = retrofitBuilder.callGetAllServicesApi(auth, language, villaId)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                _getAllServiceResponseModel.value = (response.data as List<ServicesDataModel>?)!!
            } catch (e: Exception) {
                _errorResponse.value = response.error
            }
        }
    }
}
