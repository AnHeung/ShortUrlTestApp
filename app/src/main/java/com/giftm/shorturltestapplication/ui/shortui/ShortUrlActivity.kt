package com.giftm.shorturltestapplication.ui.shortui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.giftm.shorturltestapplication.R
import com.giftm.shorturltestapplication.databinding.ActivityShortUrlBinding
import com.giftm.shorturltestapplication.ui.base.BaseActivity

class ShortUrlActivity : BaseActivity<ActivityShortUrlBinding>() {

    override val layoutResId: Int = R.layout.activity_short_url

    private val shortViewModel: ShortUrlViewModel by lazy { ShortUrlViewModel()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_short_url)


        shortViewModel.clickConvert.observe(this , Observer {

        })

        shortViewModel.clickCopyToClip.observe(this , Observer {

        })

        shortViewModel.errorMsg.observe(this , Observer {
            if(it != null){
                Toast.makeText(this@ShortUrlActivity , it, Toast.LENGTH_LONG).show()
            }
        })

        viewDataBinding.viewModel = shortViewModel
        viewDataBinding.lifecycleOwner = this
    }

    companion object{
        val TAG by lazy{ ShortUrlActivity::class.java.simpleName}
    }
}
