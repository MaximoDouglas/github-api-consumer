package com.maximo.douglas.commons.utils

object StringUtils {

    fun compactStringWithDots(string: String?, maxLength: Int = 60): String? {
        if ((string ?: "").length > maxLength) {
            return string?.subSequence(0, maxLength) as String + "..."
        }

        return string
    }

    fun gitPullRequestOpenLabelStringFormat(quantity: Int? = 0): String {
        return "$quantity open"
    }

    fun gitPullRequestClosedLabelStringFormat(quantity: Int? = 0): String {
        return " / $quantity closed"
    }

}