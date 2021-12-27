package com.onsenstamprallyapp.model


internal data class Goods(
    val title: String,
    val description: String,
    val stamps: Int, // 獲得に必要なスタンプ数
)
