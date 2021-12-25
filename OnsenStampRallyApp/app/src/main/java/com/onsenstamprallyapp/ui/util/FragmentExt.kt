package com.onsenstamprallyapp.ui.util

import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.onsenstamprallyapp.R

internal fun Fragment.showErrorDialog(message: String, onPositiveButtonClicked: () -> Unit) {
    MaterialAlertDialogBuilder(requireActivity()).apply {
        setTitle(requireContext().getString(R.string.error_dialog_title))
        setMessage(message)
        setPositiveButton(android.R.string.ok) { _, _ -> onPositiveButtonClicked() }
        setCancelable(false)
        setIcon(R.drawable.ic_onsen_icon)
    }.create().apply {
        show()
    }
}