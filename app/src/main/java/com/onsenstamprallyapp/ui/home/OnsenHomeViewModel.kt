package com.onsenstamprallyapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onsenstamprallyapp.domain.repository.OnsenInfoRepository
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.log.LogWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnsenHomeViewModel @Inject constructor(
    private val repository: OnsenInfoRepository
) : ViewModel() {
    private val logTag by LogTag()
    private val _uistate: MutableLiveData<UiState> = MutableLiveData()
    val uistate: LiveData<UiState> = _uistate

    init {
        LogWrapper.print(logTag, "init")

        // oneshot
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _uistate.value = UiState.Error(throwable)
        }) {
            repository.setupOnsenData()
        }

        // Flow
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            // Failure
            _uistate.value = UiState.Error(throwable)
        }) {
            // Success
            repository.observeOnsenInfoList().collect {
                val pickupOnsenList = it.take(3)
                _uistate.value = UiState.Success(pickupOnsenList)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        LogWrapper.print(logTag, "onCleared")
    }

    fun updateStampStatus(id: Int, isStamped: Boolean) {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            // Faire
            _uistate.value = UiState.Error(throwable)
        }) {
            // Success
            repository.updateStampStatus(id, isStamped)
        }
    }
}