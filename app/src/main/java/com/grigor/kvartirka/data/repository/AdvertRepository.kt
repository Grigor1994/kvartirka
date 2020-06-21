package com.grigor.kvartirka.data.repository

import com.grigor.kvartirka.BaseCoroutineExceptionHandler
import com.grigor.kvartirka.data.AdvertRemoteDataSource
import com.grigor.kvartirka.data.model.remote.FlatResponse
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface AdvertRepository {
    suspend fun getFlats(pointLng: Double, pointLat: Double): FlatResponse?
}

class AdvertRepositoryImpl(private val dataSource: AdvertRemoteDataSource) : AdvertRepository {
    override suspend fun getFlats(pointLng: Double, pointLat: Double): FlatResponse? {
        return withContext(Dispatchers.IO + BaseCoroutineExceptionHandler(CoroutineExceptionHandler)) {
            val response = dataSource.getFlats(pointLng, pointLat)
            if (response.isSuccessful) {
                return@withContext response.body()
            } else {
                return@withContext null
            }
        }
    }
}