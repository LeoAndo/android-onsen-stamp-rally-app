package com.onsenstamprallyapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onsenstamprallyapp.data.repository.OnsenInfoRepository
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.log.LogWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class OnsenListViewModel @Inject constructor(
    private val repository: OnsenInfoRepository
) : ViewModel() {
    private val logTag by LogTag()
    private val _uistate: MutableLiveData<UiState> = MutableLiveData()
    val uistate: LiveData<UiState> = _uistate
    private var selectedFilterItem: SelectedFilterItem = SelectedFilterItem.ALL

    init {
        LogWrapper.print(logTag, "init")

        // Flow
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _uistate.value = UiState.Error(throwable.localizedMessage)
        }) {
            repository.observeOnsenInfoList().collect { OnsenInfoList ->
                val filterOnsenInfoList = when (selectedFilterItem) {
                    SelectedFilterItem.ALL -> OnsenInfoList
                    SelectedFilterItem.STAMPED -> OnsenInfoList.filter { it.isStamped }
                    SelectedFilterItem.NO_STAMPED -> OnsenInfoList.filter { !it.isStamped }
                }
                _uistate.value = UiState.Success(filterOnsenInfoList)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        LogWrapper.print(logTag, "onCleared")
    }

    fun getOnsenList(filterItemId: Int) {
        selectedFilterItem = SelectedFilterItem.values().first { it.ordinal == filterItemId }

        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            _uistate.value = UiState.Error(throwable.localizedMessage)
        }) {
            val ret = when (selectedFilterItem) {
                SelectedFilterItem.ALL -> {
                    repository.getAllOnsenInfoList()
                }
                SelectedFilterItem.STAMPED -> {
                    repository.getStampedOnsenInfoList()
                }
                SelectedFilterItem.NO_STAMPED -> {
                    repository.getNoStampedOnsenInfoList()
                }
            }
            _uistate.value = UiState.Success(ret)
        }
    }

    fun updateStampStatus(id: Int, isStamped: Boolean) {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            // Faire
            _uistate.value = UiState.Error(throwable.localizedMessage)
        }) {
            // Success
            repository.updateStampStatus(id, isStamped)
        }
    }
}