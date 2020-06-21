package com.grigor.kvartirka.data.model.remote


import com.google.gson.annotations.SerializedName

data class Contacts(
    @SerializedName("flats_count")
    val flatsCount: Int,
    val id: Int,
    val name: String,
    val phones: List<Phone>,
    @SerializedName("send_booking_request_allowed")
    val sendBookingRequestAllowed: Boolean,
    @SerializedName("show_prepayment_warning")
    val showPrepaymentWarning: Boolean,
    val skype: String,
    @SerializedName("vk_profile")
    val vkProfile: String
)