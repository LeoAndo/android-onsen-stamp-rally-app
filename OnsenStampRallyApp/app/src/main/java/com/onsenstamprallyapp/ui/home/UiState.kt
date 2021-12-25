package com.onsenstamprallyapp.ui.home

import com.onsenstamprallyapp.model.OnsenInfo

sealed interface UiState {
    data class Success(val onsenList: List<OnsenInfo>) : UiState
    data class Error(val errorMessage: String) : UiState
}
