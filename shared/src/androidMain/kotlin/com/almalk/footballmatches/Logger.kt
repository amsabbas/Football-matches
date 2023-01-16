package com.almalk.footballmatches

import android.util.Log
import com.almalk.footballmatches.base.utils.Constants


class AndroidLogger : Logger {
    override fun print(message: String) {
        Log.i(Constants.TAG, message)
    }
}

actual fun getLogger(): Logger = AndroidLogger()