package com.onsenstamprallyapp.model

import java.io.Serializable

data class OnsenInfo(
    val id: Int,
    val name: String,
    val address: String,
    val isStamped: Boolean
) : Serializable
