package com.onsenstamprallyapp.ui.detail

import com.onsenstamprallyapp.model.OnsenInfoDetail

sealed interface UiState {
    data class Success(val onsenInfo: OnsenInfoDetail) : UiState
    data class Error(val errorMessage: String) : UiState
}
