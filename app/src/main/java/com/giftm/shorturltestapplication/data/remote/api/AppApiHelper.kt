package com.giftm.shorturltestapplication.data.remote.api

import com.giftm.shorturltestapplication.data.model.remote.ShortenUrl
import io.reactivex.Single

class AppApiHelper(private val api : Api) : ApiHelper{

    override fun getShortenUrl(url: String): Single<ShortenUrl> = api.shortUrl(url).map{it.result}
}