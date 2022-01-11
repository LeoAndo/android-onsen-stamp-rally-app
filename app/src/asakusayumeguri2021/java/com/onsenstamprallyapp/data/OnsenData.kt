package com.onsenstamprallyapp.data

import com.onsenstamprallyapp.data.room.entity.OnsenEntity

internal object OnsenData {
    val arrayData = arrayOf(
        OnsenEntity(
            name = "富士の湯",
            address = "台東区橋場２−２１−７",
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
            name = "湯どんぶり栄湯",
            address = "台東区日本堤１−４−５",
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
            name = "堤柳泉",
            address = "台東区千束４−５−４",
            latitude = 35.7236871,
            longitude = 139.7974964,
            trafficAccess = "東京メトロ日比谷線「三ノ輪」駅よりバス。「吉原大門」下車、徒歩1分",
            tel = "0338712395",
            homepageUrl = "http://teiryusen.jp/",
            regularHoliday = "月曜",
            businessHours = "１３：００−２３：００\n" + "日曜、祝日は１２：００から営業",
            explanationOfSaunaFee = "サウナあり",
        ),

        OnsenEntity(
            name = "鶴の湯",
            address = "台東区浅草５−４８−４",
            latitude = 35.7206957,
            longitude = 139.799138099999,
            trafficAccess = "つくばエクスプレス「浅草」駅より徒歩12分\n" + "東京メトロ銀座線「浅草」駅よりバス。「東浅草１丁目」下車、徒歩2分",
            tel = "0338727753",
            homepageUrl = "https://www.taitosento.com/",
            regularHoliday = "木曜\n" + "祝日は前日休",
            businessHours = "１４：００−２３：００",
            explanationOfSaunaFee = "サウナあり",
        ),

        OnsenEntity(
            name = "アクアプレイス旭",
            address = "台東区浅草５−１０−５",
            latitude = 35.7201762,
            longitude = 139.794533,
            trafficAccess = "つくばエクスプレス「浅草」駅下車、徒歩7分\n" + "東京メトロ銀座線「田原町」駅よりバス。「浅草４丁目」下車、徒歩1分",
            tel = "0338723091",
            homepageUrl = "https://www.taitosento.com/",
            regularHoliday = "火曜",
            businessHours = "１５：００−２５：００",
            explanationOfSaunaFee = "サウナあり",
        ),


        OnsenEntity(
            name = "曙湯",
            address = "台東区浅草４−１７−１",
            latitude = 35.7182736,
            longitude = 139.795435799999,
            trafficAccess = "東京メトロ銀座線「浅草」駅下車、徒歩15分",
            tel = "0338736750",
            homepageUrl = "https://www.taitosento.com/",
            regularHoliday = "第１・第３金曜",
            businessHours = "１５：００−２５：００",
            explanationOfSaunaFee = "サウナなし",
        ),


        OnsenEntity(
            name = "日の出湯",
            address = "台東区元浅草２−１０−５",
            latitude = 35.7106463,
            longitude = 139.784286999999,
            trafficAccess = "東京メトロ銀座線「稲荷町」駅下車、徒歩3分",
            tel = "0338410969",
            homepageUrl = "http://hinodeyu.com/",
            regularHoliday = "水曜",
            businessHours = "１５：００−２３：４０",
            explanationOfSaunaFee = "サウナあり",
        ),

        OnsenEntity(
            name = "三筋湯",
            address = "台東区三筋２−１３−２",
            latitude = 35.7054413,
            longitude = 139.786498299999,
            trafficAccess = "都営浅草線「蔵前」駅下車、徒歩8分",
            tel = "0338512683",
            homepageUrl = "https://www.taitosento.com/",
            regularHoliday = "月曜",
            businessHours = "１５：００−２３：３０",
            explanationOfSaunaFee = "サウナなし",
        ),

        OnsenEntity(
            name = "帝国湯",
            address = "台東区浅草橋５−２３−６",
            latitude = 35.7019665,
            longitude = 139.781762599999,
            trafficAccess = "総武線「浅草橋」駅下車、徒歩6分",
            tel = "0338512785",
            homepageUrl = "https://www.taitosento.com/",
            regularHoliday = "月曜",
            businessHours = "１５：００−２３：３０",
            explanationOfSaunaFee = "サウナなし",
        ),

        OnsenEntity(
            name = "鶴の湯",
            address = "台東区浅草橋５−２７−２",
            latitude = 35.7012777,
            longitude = 139.7834626,
            trafficAccess = "総武線「浅草橋」駅下車、徒歩6分",
            tel = "0338514569",
            regularHoliday = "土曜",
            businessHours = "１５：３０−２４：００",
            explanationOfSaunaFee = "サウナなし",
        ),

        OnsenEntity(
            name = "弁天湯",
            address = "台東区浅草橋１−３３−６ 浅草橋シティハイツ１階",
            latitude = 35.6985003,
            longitude = 139.784951399999,
            trafficAccess = "都営浅草線「浅草橋」駅下車、徒歩2分",
            tel = "0338647100",
            homepageUrl = "http://www7b.biglobe.ne.jp/~bentenyu/",
            twitterUrl = "https://twitter.com/bentenyu",
            regularHoliday = "第２、４月曜\n" + "１月１日は休業",
            businessHours = "１５：３０−２３：００",
            explanationOfSaunaFee = "サウナなし",
        ),
    )
}