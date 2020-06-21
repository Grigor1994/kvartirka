package com.grigor.kvartirka.di

import com.grigor.kvartirka.data.NetworkManager
import com.grigor.kvartirka.data.repository.AdvertRepository
import com.grigor.kvartirka.data.repository.AdvertRepositoryImpl
import com.grigor.kvartirka.ui.MainAdvertsFragment
import com.grigor.kvartirka.ui.MainAdvertsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val appModule = module {
    single { NetworkManager.getApiService() }
    single { AdvertRepositoryImpl(get()) as AdvertRepository }

    viewModel { MainAdvertsViewModel(get()) }

    scope(named<MainAdvertsFragment>()) {
    }
}