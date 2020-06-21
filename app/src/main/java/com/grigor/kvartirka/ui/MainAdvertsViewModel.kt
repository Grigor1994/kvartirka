package com.grigor.kvartirka.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grigor.kvartirka.data.model.remote.FlatResponse
import com.grigor.kvartirka.data.repository.AdvertRepository
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class MainAdvertsViewModel(private val repository: AdvertRepository) : ViewModel(), KoinComponent {
    private val _advertsLiveData = MutableLiveData<FlatResponse?>()
    val advertsLiveData: LiveData<FlatResponse?>
        get() = _advertsLiveData


    fun getFlats(pointLng:Double,pointLat:Double){
        viewModelScope.launch {
            _advertsLiveData.value=repository.getFlats(pointLng,pointLat)
        }
    }
}