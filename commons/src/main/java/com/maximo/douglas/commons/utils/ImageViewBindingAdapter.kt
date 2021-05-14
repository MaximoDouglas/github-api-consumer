package com.maximo.douglas.commons.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.maximo.douglas.commons.R

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["imageUri"])
    fun ImageView.setImageUri(imageUri: String? = "") {
        Glide.with(context)
            .load(imageUri)
            .placeholder(R.drawable.ic_user)
            .error(R.drawable.ic_user)
            .transform(CircleCrop())
            .into(this)
    }

}