package com.almalk.footballmatches.base.utils

import android.util.Log
import com.almalk.footballmatches.base.utils.Constants
import com.almalk.footballmatches.base.utils.Logger


class AndroidLogger : Logger {
    override fun print(message: String) {
        Log.i(Constants.TAG, message)
    }
}

actual fun getLogger(): Logger = AndroidLogger()