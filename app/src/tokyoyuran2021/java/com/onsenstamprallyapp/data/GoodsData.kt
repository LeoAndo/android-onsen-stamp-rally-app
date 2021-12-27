package com.onsenstamprallyapp.data

import com.onsenstamprallyapp.model.Goods

internal object GoodsData {
    val dataList = listOf(
        Goods(
            title = "完全制覇証",
            description = "目標完全制覇で、もれなくもらえる",
            stamps = 16
        ),
        Goods(
            title = "オリジナルTシャツ",
            description = "目標完全制覇で、もれなくもらえる",
            stamps = 16
        ),
        Goods(
            title = "オリジナルタオル",
            description = "ゆらんスリー、常連ファイブの中から先着各250名様、目標完全制覇の中から先着100名様",
            stamps = 3
        ),
        Goods(
            title = "オリジナル缶バッジ",
            description = "オリジナルタオルの先着終了した場合に、もらえる",
            stamps = 3
        ),
    )
}