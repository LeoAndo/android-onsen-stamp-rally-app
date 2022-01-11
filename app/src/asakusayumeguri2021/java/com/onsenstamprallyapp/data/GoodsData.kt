package com.onsenstamprallyapp.data

import com.onsenstamprallyapp.model.Goods

internal object GoodsData {
    val dataList = listOf(
        Goods(
            title = "Monaca",
            description = "Monaca を使ったアプリ開発を行いました",
            stamps = 5
        ),
        Goods(
            title = "Unityのインストール",
            description = "手順書を見ながら、Unityの環境構築を行いました",
            stamps = 8
        ),
    )
}