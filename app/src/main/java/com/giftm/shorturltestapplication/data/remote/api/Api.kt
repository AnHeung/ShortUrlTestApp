package com.giftm.shorturltestapplication.data.remote.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v1/util/shorturl")
    fun shortUrl(@Query("url") url: String ) : Single<ShortApiResponse>
}