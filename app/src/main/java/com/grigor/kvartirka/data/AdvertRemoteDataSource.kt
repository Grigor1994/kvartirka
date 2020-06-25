package com.grigor.kvartirka.data

import com.grigor.kvartirka.data.model.remote.FlatResponse
import com.grigor.kvartirka.data.model.remote.country.CountryResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface AdvertRemoteDataSource {
    @GET("flats")
    suspend fun getFlats(
        @Query("point_lng") pointLng: Double,
        @Query("point_lat") pointLat: Double
    ): retrofit2.Response<FlatResponse?>

    @GET("country")
    suspend fun getCountry(): retrofit2.Response<CountryResponse?>
}
