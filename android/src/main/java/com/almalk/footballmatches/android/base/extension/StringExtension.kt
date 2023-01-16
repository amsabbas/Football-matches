package com.almalk.footballmatches.android.base.extension

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String?.formatDate(): String {
    val newDate: Date? = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(this)
    newDate?.let {
        return SimpleDateFormat("yyyy/MM/dd").format(newDate)
    } ?: return ""
}