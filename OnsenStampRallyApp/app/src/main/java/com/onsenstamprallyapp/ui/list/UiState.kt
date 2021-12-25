package com.onsenstamprallyapp.ui.list

import com.onsenstamprallyapp.model.OnsenInfo

sealed interface UiState {
    data class Success(val onsenList: List<OnsenInfo>) : UiState
    data class Error(val errorMessage: String) : UiState
}

enum class SelectedFilterItem {
    ALL, STAMPED, NO_STAMPED
}
