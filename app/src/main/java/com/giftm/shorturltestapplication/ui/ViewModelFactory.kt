package com.giftm.shorturltestapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.giftm.shorturltestapplication.data.DataManager
import com.giftm.shorturltestapplication.ui.shortui.ShortUrlViewModel

@Suppress("UNCHECKED_CAST")
class ShortenUrlViewModelFactory(private val dataManager:  DataManager): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShortUrlViewModel(dataManager) as T
    }
}