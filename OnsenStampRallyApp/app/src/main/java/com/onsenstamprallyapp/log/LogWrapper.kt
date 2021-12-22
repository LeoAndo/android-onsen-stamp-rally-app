package com.onsenstamprallyapp.log

import android.util.Log
import com.onsenstamprallyapp.BuildConfig

internal object LogWrapper {
    fun print(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message)
        }
    }
}