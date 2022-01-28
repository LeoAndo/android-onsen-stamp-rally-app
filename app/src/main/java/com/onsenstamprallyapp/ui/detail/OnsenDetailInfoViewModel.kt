package com.onsenstamprallyapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onsenstamprallyapp.data.SafeResult
import com.onsenstamprallyapp.domain.repository.OnsenInfoRepository
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.log.LogWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
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
        viewModelScope.launch {
            when (val onsenData = repository.getOnsenInfoDetail(id)) {
                is SafeResult.Error -> {
                    _uistate.value = UiState.Error(onsenData.errorResult)
                }
                is SafeResult.Success -> {
                    _uistate.value = UiState.Success(onsenData.data)
                }
            }
        }
    }
}