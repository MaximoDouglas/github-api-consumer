package com.maximo.douglas.commons.utils

import android.os.Bundle

object FragmentUtils {

    fun bundleContainsKeys(bundle: Bundle?, vararg keys: String): Boolean {
        bundle?.let {
            for (key in keys) {
                if (!bundle.containsKey(key)) {
                    return false
                }
            }
            return true
        }
        return false
    }

}