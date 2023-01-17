package com.almalk.footballmatches.base.utils

data class AppException(
    val exceptionType: AppExceptionType,
    val code: String? = null,
    private val _message: String? = null,
    private val _exception: Throwable? = null
) : RuntimeException(_message, _exception)


enum class AppExceptionType {
    Network,
    UnAuthorized,
    API,
    Unknown,
}


fun Throwable.toAppException(appExceptionType: AppExceptionType = AppExceptionType.Unknown): AppException {
    return AppException(appExceptionType, "", this.message ?: "", this)
}

