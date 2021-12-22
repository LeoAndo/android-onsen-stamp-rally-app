package com.onsenstamprallyapp.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel

class OnsenListViewModel(

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
        private const val LOG_TAG = "OnsenListViewModel"
    }
}