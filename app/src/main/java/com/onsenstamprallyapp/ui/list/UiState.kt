package com.onsenstamprallyapp.ui.list

import com.onsenstamprallyapp.domain.model.OnsenInfo

sealed interface UiState {
    data class Success(val onsenList: List<OnsenInfo>) : UiState
    data class Error(val throwable: Throwable) : UiState
}

enum class SelectedFilterItem {
    ALL, STAMPED, NO_STAMPED
}
