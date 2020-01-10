package com.giftm.shorturltestapplication.ui.shortui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.giftm.shorturltestapplication.R
import com.giftm.shorturltestapplication.databinding.ActivityShortUrlBinding
import com.giftm.shorturltestapplication.ui.ShortenUrlViewModelFactory
import com.giftm.shorturltestapplication.ui.base.BaseActivity
import org.koin.android.ext.android.inject

class ShortUrlActivity : BaseActivity<ActivityShortUrlBinding>() {

    override val layoutResId: Int = R.layout.activity_short_url

    private val shortViewModelFactory : ShortenUrlViewModelFactory by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_short_url)

        val shortViewModel  = ViewModelProviders.of(this ,shortViewModelFactory).get(ShortUrlViewModel::class.java)

        shortViewModel.clickConvert.observe(this , Observer {
            shortViewModel.getShortenUrl(viewDataBinding.shortEdtxt.text.toString())
        })

        shortViewModel.clickCopyToClip.observe(this , Observer {

        })

        shortViewModel.errorMsg.observe(this , Observer {
            if(it != null){
                Toast.makeText(this@ShortUrlActivity , it, Toast.LENGTH_LONG).show()
            }
        })

        viewDataBinding.viewModel = shortViewModel
        viewDataBinding.activity = this
        viewDataBinding.lifecycleOwner = this
    }

    companion object{
        val TAG by lazy{ ShortUrlActivity::class.java.simpleName}
    }

    fun showToast(){
        Log.d("테스트","ㅅㄷ")
        Toast.makeText(this@ShortUrlActivity , "테스트" , Toast.LENGTH_LONG).show()
    }
}
