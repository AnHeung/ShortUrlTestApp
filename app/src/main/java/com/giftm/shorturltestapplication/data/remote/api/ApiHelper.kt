package com.giftm.shorturltestapplication.data.remote.api

import com.giftm.shorturltestapplication.data.model.remote.ShortenUrl
import io.reactivex.Single


interface ApiHelper {

    fun getShortenUrl(url: String): Single<ShortenUrl>
}