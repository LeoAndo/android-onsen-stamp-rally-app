package com.onsenstamprallyapp.data.repository

import com.onsenstamprallyapp.model.OnsenInfo
import com.onsenstamprallyapp.model.OnsenInfoDetail
import kotlinx.coroutines.flow.Flow

interface OnsenInfoRepository {
    fun observeOnsenInfoList(): Flow<List<OnsenInfo>>
    suspend fun getAllOnsenInfoList(): List<OnsenInfo>
    suspend fun getStampedOnsenInfoList(): List<OnsenInfo>
    suspend fun getNoStampedOnsenInfoList(): List<OnsenInfo>
    suspend fun getOnsenInfoDetail(id: Int): OnsenInfoDetail
    suspend fun setupOnsenData()
    suspend fun updateStampStatus(id: Int, isStamped: Boolean)
}