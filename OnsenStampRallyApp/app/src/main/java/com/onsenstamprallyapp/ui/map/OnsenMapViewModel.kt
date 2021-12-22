package com.onsenstamprallyapp.ui.map

import androidx.lifecycle.ViewModel
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.log.LogWrapper

class OnsenMapViewModel(

) : ViewModel() {
    private val logTag by LogTag()

    init {
        LogWrapper.print(logTag, "init")
    }

    override fun onCleared() {
        super.onCleared()
        LogWrapper.print(logTag, "onCleared")
    }

    fun print() {
        LogWrapper.print(logTag, "print")
    }
}