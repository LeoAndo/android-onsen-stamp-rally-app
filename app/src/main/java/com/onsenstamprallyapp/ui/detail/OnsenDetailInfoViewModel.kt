package com.onsenstamprallyapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onsenstamprallyapp.data.repository.OnsenInfoRepository
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.log.LogWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnsenDetailInfoViewModel @Inject constructor(
    private val repository: OnsenInfoRepository
) : ViewModel() {
    private val logTag by LogTag()
    private val _uistate: MutableLiveData<UiState> = MutableLiveData()
    val uistate: LiveData<UiState> = _uistate

    init {
        LogWrapper.print(logTag, "init")
    }

    override fun onCleared() {
        super.onCleared()
        LogWrapper.print(logTag, "onCleared")
    }

    fun getOnsenInfo(id: Int) {
        // oneshot
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _uistate.value = UiState.Error(throwable)
        }) {
            _uistate.value = UiState.Success(repository.getOnsenInfoDetail(id))
        }
    }
}