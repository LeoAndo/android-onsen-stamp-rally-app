package com.onsenstamprallyapp.log

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

internal class LogTag : ReadOnlyProperty<Any?, String> {
    private val prefix = "Onsen_"
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return prefix + (thisRef?.javaClass?.simpleName ?: "UNKNOWN_SCREEN_NAME")
    }
}