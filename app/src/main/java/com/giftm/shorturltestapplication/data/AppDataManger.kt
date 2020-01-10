package com.giftm.shorturltestapplication.data

import com.giftm.shorturltestapplication.data.model.remote.ShortenUrl
import com.giftm.shorturltestapplication.data.remote.api.Api
import io.reactivex.Single

class AppDataManger(val api: Api) : DataManager {

    override fun getShortenUrl(url: String): Single<ShortenUrl> = api.shortUrl(url).map { it.result }

}