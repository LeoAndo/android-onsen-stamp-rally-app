package com.onsenstamprallyapp.ui.stamped

import androidx.lifecycle.ViewModel
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.log.LogWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnsenStampedListViewModel @Inject constructor(

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