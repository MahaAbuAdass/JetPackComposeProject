package com.example.jetpackcomposeproject.ui.dashboard

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.IgnoredOnParcel

@Parcelize
data class AllServicesRequestModel(
    @SerializedName
        ("MobileNumber") val mobileNumber: String?
): Parcelable


data class ServicesDataModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("enumId") val enumId: Int?,
    @SerializedName("order") val order: Int?,
    @SerializedName("iconImg") val iconImg: String?,
    @SerializedName("title") val title: String?
)


data class ServicesResponseModel(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: List<ServicesDataModel?>?,
    @SerializedName("error") val error: BaseError?
)


@Parcelize
data class BaseError(
    @SerializedName("errors") val errors: List<String>?,
    @SerializedName("messageEn") val messageEn: String?,
    @SerializedName("messageAr") val messageAr: String?
) : Parcelable {
    @IgnoredOnParcel
    val message: String?
        get() {
            val selectedLanguage = "1"
            return "1"
        }
}