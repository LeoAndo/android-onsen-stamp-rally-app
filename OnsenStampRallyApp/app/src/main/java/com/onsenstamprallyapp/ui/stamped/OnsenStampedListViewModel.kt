package com.onsenstamprallyapp.ui.stamped

import android.util.Log
import androidx.lifecycle.ViewModel

class OnsenStampedListViewModel(

) : ViewModel() {
    init {
        Log.d(LOG_TAG, "init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(LOG_TAG, "onCleared")
    }

    fun print() {
        Log.d(LOG_TAG, "print")
    }

    companion object {
        private const val LOG_TAG = "OnsenStampedListViewModel"
    }
}