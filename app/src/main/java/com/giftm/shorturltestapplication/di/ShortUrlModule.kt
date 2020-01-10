package com.giftm.shorturltestapplication.di

import com.giftm.shorturltestapplication.data.AppDataManger
import com.giftm.shorturltestapplication.data.DataManager
import com.giftm.shorturltestapplication.ui.ShortenUrlViewModelFactory
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val shortModule : Module = module {

    single{
        AppDataManger(get()) as DataManager
    }


    factory {
        ShortenUrlViewModelFactory(get())
    }
}