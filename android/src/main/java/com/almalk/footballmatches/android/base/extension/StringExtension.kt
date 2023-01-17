package com.almalk.footballmatches.android.base.extension

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String?.formatDateByYearMonthDay(): String {
    val newDate: Date? = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(this)
    newDate?.let {
        return SimpleDateFormat("dd/MM/yyyy").format(newDate)
    } ?: return ""
}

@SuppressLint("SimpleDateFormat")
fun String?.formatDateByHourMin(): String {
    val newDate: Date? = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(this)
    newDate?.let {
        return SimpleDateFormat("HH:mm").format(newDate)
    } ?: return ""
}