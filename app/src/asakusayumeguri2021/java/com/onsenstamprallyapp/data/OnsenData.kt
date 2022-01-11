package com.onsenstamprallyapp.data

import com.onsenstamprallyapp.data.room.entity.OnsenEntity

internal object OnsenData {
    val arrayData = arrayOf(
        OnsenEntity(
            name = "1回目 テキスト",
            address = "オブジェクトの追加方法",
            latitude = 35.7277092,
            longitude = 139.8053429,
            trafficAccess = "東京メトロ日比谷線「南千住」駅下車、徒歩15分",
            tel = "0338769530",
            homepageUrl = "https://www.taitosento.com/",
            regularHoliday = "金曜",
            businessHours = "１４：００−２３：００",
            explanationOfSaunaFee = "サウナあり",
        ),
        OnsenEntity(
            name = "1回目 テキスト",
            address = "オブジェクトの操作方法",
            latitude = 35.7254842,
            longitude = 139.7987046,
            trafficAccess = "東京メトロ日比谷線「三ノ輪」駅下車、徒歩10分",
            tel = "0338752885",
            homepageUrl = "http://sakaeyu.com/",
            twitterUrl = "https://twitter.com/yudonburi",
            regularHoliday = "水曜",
            businessHours = "１４：００−２４：００\n" + "日曜、祝日は１２：００から営業",
            explanationOfSaunaFee = "サウナあり",
        ),

        OnsenEntity(
            name = "2回目 テキスト",
            address = "スクリプトの作成方法",
            latitude = 35.7236871,
            longitude = 139.7974964,
            trafficAccess = "東京メトロ日比谷線「三ノ輪」駅よりバス。「吉原大門」下車、徒歩1分",
            tel = "0338712395",
            homepageUrl = "http://teiryusen.jp/",
            regularHoliday = "月曜",
            businessHours = "１３：００−２３：００\n" + "日曜、祝日は１２：００から営業",
            explanationOfSaunaFee = "サウナあり",
        ),
    )
}