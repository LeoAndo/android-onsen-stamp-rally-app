package com.onsenstamprallyapp.data

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * A generic class that holds a value or an exception
 */
internal sealed class SafeResult<out R> {
    data class Success<out T>(val data: T) : SafeResult<T>()
    data class Error(val errorResult: ErrorResult) : SafeResult<Nothing>()
}

internal sealed class ErrorResult : Exception() {
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

internal fun <T> SafeResult<T>.successOr(fallback: T): T {
    return (this as? SafeResult.Success<T>)?.data ?: fallback
}

suspend fun <T> dbCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> T
): T {
    return withContext(dispatcher) {
        Log.w("dbCall", "currentThread: " + Thread.currentThread().name)
        try {
            apiCall.invoke()
        } catch (e: Throwable) {
            throw ErrorResult.OtherError(e.localizedMessage)
        }
    }
}