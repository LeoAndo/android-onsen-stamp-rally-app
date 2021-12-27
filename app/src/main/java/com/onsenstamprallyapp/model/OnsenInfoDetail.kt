package com.onsenstamprallyapp.model

data class OnsenInfoDetail(
    val id: Int,
    val name: String, // 店舗名
    val address: String, // 住所
    val latitude: Double, // 緯度
    val longitude: Double, // 軽度
    val trafficAccess: String, // 交通アクセス
    val tel: String, // 電話番号
    val mailAddress: String, // メールアドレス
    val instagramUrl: String, // インスタグラムのURL
    val twitterUrl: String,  // twitterのURL
    val facebookUrl: String,  // facebookのURL
    val homepageUrl: String, // ホームページのURL
    val regularHoliday: String, //定休日
    val businessHours: String, //営業時間
    val explanationOfSaunaFee: String, // サウナ料金の説明
    val isRunningStation: Boolean,// ランニングステーション フラグ
    val isFreeWifi: Boolean, // Free wifiサポート店 フラグ
    val isStamped: Boolean, // スタンプ済み フラグ
)
