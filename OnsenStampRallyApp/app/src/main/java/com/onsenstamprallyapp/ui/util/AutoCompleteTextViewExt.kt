package com.onsenstamprallyapp.ui.util

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.onsenstamprallyapp.R

interface AutoCompleteTextViewExt {
    fun AutoCompleteTextView.setupSearchFilters() {
        val items = resources.getStringArray(
            R.array.search_filter_items
        )
        val adapter = ArrayAdapter(context, R.layout.dropdown_menu, items)
        val defaultValue = items[0]
        setText(defaultValue)
        setAdapter(adapter)
    }
}