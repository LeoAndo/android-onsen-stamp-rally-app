package com.onsenstamprallyapp.data

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * A generic class that holds a value or an exception
 */
sealed class SafeResult<out R> {
    data class Success<out T>(val data: T) : SafeResult<T>()
    data class Error(val errorResult: ErrorResult) : SafeResult<Nothing>()
}

sealed class ErrorResult : Exception() {
    data class UnAuthorizedError(override val message: String? = "UnAuthorizedError") :
        ErrorResult()

    data class BadRequestError(override val message: String? = "BadRequestError") :
        ErrorResult()

    data class NotFoundError(override val message: String? = "NotFoundError") :
        ErrorResult()

    data class NetworkError(override val message: String? = "NetworkError") :
        ErrorResult()

    data class OtherError(override val message: String? = "OtherError") :
        ErrorResult()
}

fun <T> SafeResult<T>.successOr(fallback: T): T {
    return (this as? SafeResult.Success<T>)?.data ?: fallback
}

internal suspend fun <T> safeCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): SafeResult<T> {
    return withContext(dispatcher) {
        Log.w("safeCall", "currentThread: " + Thread.currentThread().name)
        try {
            SafeResult.Success(apiCall.invoke())
        } catch (e: Throwable) {
            SafeResult.Error(ErrorResult.OtherError(e.localizedMessage))
        }
    }
}