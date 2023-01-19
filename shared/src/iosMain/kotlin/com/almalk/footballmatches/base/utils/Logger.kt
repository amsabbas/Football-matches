package com.almalk.footballmatches.base.utils

import platform.Foundation.NSLog

class IOSLogger : Logger {
    override fun print(message: String) {
        NSLog(message)
    }
}

actual fun getLogger(): Logger = IOSLogger()