package com.onsenstamprallyapp.ui.detail

import com.onsenstamprallyapp.data.ErrorResult
import com.onsenstamprallyapp.domain.model.OnsenInfoDetail

sealed interface UiState {
    data class Success(val onsenInfo: OnsenInfoDetail) : UiState
    data class Error(val throwable: ErrorResult) : UiState
}
