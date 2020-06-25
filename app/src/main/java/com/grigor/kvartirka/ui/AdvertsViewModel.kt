package com.grigor.kvartirka.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grigor.kvartirka.data.model.remote.FlatResponse
import com.grigor.kvartirka.data.repository.AdvertRepository
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class AdvertsViewModel(private val repository: AdvertRepository) : ViewModel(),
    KoinComponent {

    private val _flatsLiveData = MutableLiveData<FlatResponse?>()
    val flatsLiveData: LiveData<FlatResponse?>
        get() = _flatsLiveData

    fun getFlats(pointLng: Double, pointLat: Double) {
        viewModelScope.launch {
            _flatsLiveData.value = repository.getFlats(pointLng, pointLat)
        }
    }
}