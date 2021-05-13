package com.maximo.douglas.githubconsumer.testutils

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["visibleOrGone"])
    fun View.setVisibleOrGone(show: Boolean) {
        visibility = if (show) View.VISIBLE else View.GONE
    }

}
