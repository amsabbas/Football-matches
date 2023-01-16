package com.almalk.footballmatches

import platform.Foundation.NSLog

class IOSLogger : Logger {
    override fun print(message: String) {
        NSLog(message)
    }
}

actual fun getLogger(): Logger = IOSLogger()