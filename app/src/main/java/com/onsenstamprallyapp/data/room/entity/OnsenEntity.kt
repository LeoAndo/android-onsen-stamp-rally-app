package com.onsenstamprallyapp.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onsenstamprallyapp.model.OnsenInfo
import com.onsenstamprallyapp.model.OnsenInfoDetail

internal const val TABLE_NAME_ONSEN = "onsen"

@Entity(tableName = TABLE_NAME_ONSEN)
internal data class OnsenEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String, // 店舗名
    val address: String, // 住所
    val latitude: Double, // 緯度
    val longitude: Double, // 軽度
    val trafficAccess: String, // 交通アクセス
    val tel: String, // 電話番号
    val mailAddress: String = "", // メールアドレス
    val instagramUrl: String = "", // インスタグラムのURL
    val twitterUrl: String = "",  // twitterのURL
    val facebookUrl: String = "",  // twitterのURL
    val homepageUrl: String = "", // ホームページのURL
    val regularHoliday: String, //定休日
    val businessHours: String, //営業時間
    val explanationOfSaunaFee: String, // サウナ料金の説明
    val isRunningStation: Boolean = false,// ランニングステーション フラグ
    val isFreeWifi: Boolean = false, // Free wifiサポート店 フラグ
    val isStamped: Boolean = false, // スタンプ済み フラグ
)

internal fun List<OnsenEntity>.toOnsenInfoList(): List<OnsenInfo> {
    return this.mapIndexed { _, onsenEntity ->
        OnsenInfo(
            id = onsenEntity.id,
            name = onsenEntity.name,
            address = onsenEntity.address,
            isStamped = onsenEntity.isStamped
        )
    }
}

internal fun OnsenEntity.toOnsenInfo(): OnsenInfo =
    OnsenInfo(id = id, name = name, address = address, isStamped = isStamped)

internal fun OnsenEntity.toOnsenInfoDetail(): OnsenInfoDetail =
    OnsenInfoDetail(
        id,
        name,
        address,
        latitude,
        longitude,
        trafficAccess,
        tel,
        mailAddress,
        instagramUrl,
        twitterUrl,
        facebookUrl,
        homepageUrl,
        regularHoliday,
        businessHours,
        explanationOfSaunaFee,
        isRunningStation,
        isFreeWifi,
        isStamped
    )