package com.onsenstamprallyapp.data

import com.onsenstamprallyapp.model.Goods

internal object GoodsData {
    val dataList = listOf(
        Goods(
            title = "オリジナルタオル",
            description = "各銭湯の名前が入ったオリジナルタオル全11種",
            stamps = 5
        ),
        Goods(
            title = "オリジナルマスク",
            description = "浅草銭湯オリジナルマスク全1種",
            stamps = 5
        ),
    )
}