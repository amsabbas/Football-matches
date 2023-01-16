package com.almalk.footballmatches

interface Logger {
    fun print(message: String)
}

expect fun getLogger(): Logger
