package com.almalk.footballmatches.android.base.extension

import android.content.Context
import com.almalk.footballmatches.android.R
import com.almalk.footballmatches.base.utils.AppException
import com.almalk.footballmatches.base.utils.AppExceptionType


data class UIErrorModel(
    var exceptionType: AppExceptionType = AppExceptionType.Unknown,
    val message: String = "",
)

fun Throwable.getErrorMessage(context: Context): UIErrorModel {
    var exceptionType: AppExceptionType = AppExceptionType.Unknown
    val errMsg = if (this is AppException) {
        exceptionType = this.exceptionType
        when (this.exceptionType) {
            AppExceptionType.UnAuthorized -> context.getString(R.string.unauthorized)
            AppExceptionType.API ->
                if (this.message.isNullOrEmpty()) context.getString(R.string.unknown_error)
                else this.message ?: ""
            AppExceptionType.Network ->
                context.getString(R.string.network_error)
            else ->
                context.getString(R.string.unknown_error)
        }
    } else
        context.getString(R.string.unknown_error)
    return UIErrorModel(exceptionType, errMsg)
}
