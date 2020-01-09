package com.giftm.shorturltestapplication.ui.shortui

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.giftm.shorturltestapplication.ui.base.BaseViewModel
import com.giftm.shorturltestapplication.utils.SingleLiveEvent
import com.rengwuxian.materialedittext.validation.METValidator
import com.rengwuxian.materialedittext.validation.RegexpValidator

class ShortUrlViewModel : BaseViewModel() {

    val shortenUrl = MutableLiveData<String>()
    val errorMsg = MutableLiveData<String>()
    val clickCopyToClip = SingleLiveEvent<String>()
    val clickOpenWeb = SingleLiveEvent<String>()
    val clickConvert = SingleLiveEvent<Any>()

    val isVisible = MutableLiveData<Boolean>()


    fun getUrlValidator(errorMsg : String) : METValidator = RegexpValidator(errorMsg , Patterns.WEB_URL.pattern())

    fun getShortenUrl (url : String){

    }

    fun clickConvert(){
        clickConvert.call()
    }

    fun clickCopyClipBoard(){
        clickCopyToClip.value = shortenUrl.value
    }

    fun clickOpenWeb(){
        clickCopyToClip.value = shortenUrl.value
    }
}