package com.giftm.shorturltestapplication.ui.shortui

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.giftm.shorturltestapplication.data.DataManager
import com.giftm.shorturltestapplication.ui.base.BaseViewModel
import com.giftm.shorturltestapplication.utils.SingleLiveEvent
import com.giftm.shorturltestapplication.utils.setMutableText
import com.rengwuxian.materialedittext.validation.METValidator
import com.rengwuxian.materialedittext.validation.RegexpValidator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ShortUrlViewModel(private val dataManager: DataManager) : BaseViewModel() {

    val shortenUrl = MutableLiveData<String>()
    val errorMsg = MutableLiveData<String>()
    val clickCopyToClip = SingleLiveEvent<String>()
    val clickOpenWeb = SingleLiveEvent<String>()
    val clickConvert = SingleLiveEvent<Any>()
    
    val showResult =  MutableLiveData<Boolean>() 

    val isVisible = MutableLiveData<Int>()


    fun getUrlValidator(errorMsg : String) : METValidator = RegexpValidator(errorMsg , Patterns.WEB_URL.pattern())

    fun getShortenUrl (url : String){

        addDisposable(dataManager
            .getShortenUrl(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({showResult.value = true
                        shortenUrl.value = it.url}
                , {it.message}))
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