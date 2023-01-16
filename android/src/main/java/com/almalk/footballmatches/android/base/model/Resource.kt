package com.almalk.footballmatches.android.base.model

data class Resource<out T>(
    val state: ResourceState,
    val data: T? = null,
    val exception: Throwable? = null,
)
