package com.giftm.shorturltestapplication.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

@BindingAdapter
fun isVisible(view: View, visibility: MutableLiveData<Int>?) {

    val parentActivity = view.getParentActivity()

    if (parentActivity != null && visibility != null) {
        visibility.observe(
            parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter
fun setMutableText(txtView: TextView, content: MutableLiveData<String>?) {

    val parentActivity = txtView.getParentActivity()

    if (parentActivity != null && content != null) {
        content.observe(parentActivity, Observer { value -> txtView.text = value ?: "" })
    }

}