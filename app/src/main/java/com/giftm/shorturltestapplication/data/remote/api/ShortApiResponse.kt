package com.giftm.shorturltestapplication.data.remote.api

import com.giftm.shorturltestapplication.data.model.remote.ShortenUrl

data class ShortApiResponse(val message: String , val result : ShortenUrl, val code : String)