package com.almalk.footballmatches.base.utils

interface Logger {
    fun print(message: String)
}

expect fun getLogger(): Logger
