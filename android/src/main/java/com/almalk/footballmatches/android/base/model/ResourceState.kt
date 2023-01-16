package com.almalk.footballmatches.android.base.model

sealed class ResourceState {
    object Empty : ResourceState()
    object Loading : ResourceState()
    object Success : ResourceState()
    object Error : ResourceState()
}