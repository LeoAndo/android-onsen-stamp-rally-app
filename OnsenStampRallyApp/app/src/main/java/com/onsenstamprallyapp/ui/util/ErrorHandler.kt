package com.onsenstamprallyapp.ui.util

import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.onsenstamprallyapp.R
import kotlinx.coroutines.CoroutineExceptionHandler

internal class ErrorHandler(
    private val fragment: Fragment,
    onPositiveButtonClicked: () -> Unit
) {
    val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->

        MaterialAlertDialogBuilder(fragment.requireActivity()).apply {
            setTitle(fragment.requireContext().getString(R.string.error_dialog_title))
            setMessage(throwable.localizedMessage)
            setPositiveButton(android.R.string.ok) { _, _ -> onPositiveButtonClicked() }
            setCancelable(false)
            setIcon(R.drawable.ic_onsen_icon)
        }.create().apply {
            show()
        }

    }
}