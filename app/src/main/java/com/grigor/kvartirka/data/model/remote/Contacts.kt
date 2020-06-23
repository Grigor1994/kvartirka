package com.grigor.kvartirka.data.model.remote


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contacts(
    @Expose @SerializedName("flats_count") val flatsCount: Int,
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("phones") val phones: List<Phone>,
    @Expose @SerializedName("send_booking_request_allowed") val sendBookingRequestAllowed: Boolean,
    @Expose @SerializedName("show_prepayment_warning") val showPrepaymentWarning: Boolean,
    @Expose @SerializedName("skype") val skype: String,
    @Expose @SerializedName("vk_profile") val vkProfile: String
) : Parcelable