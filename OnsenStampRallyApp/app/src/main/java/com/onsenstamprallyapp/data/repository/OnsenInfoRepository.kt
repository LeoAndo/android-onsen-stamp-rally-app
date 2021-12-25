package com.onsenstamprallyapp.data.repository

import com.onsenstamprallyapp.model.OnsenInfo
import kotlinx.coroutines.flow.Flow

interface OnsenInfoRepository {
    fun getOnsenInfoList(): Flow<List<OnsenInfo>>
    suspend fun getAllOnsenInfoList(): List<OnsenInfo>
    suspend fun getStampedOnsenInfoList(): List<OnsenInfo>
    suspend fun getNoStampedOnsenInfoList(): List<OnsenInfo>
    suspend fun getOnsenInfo(id: Int): OnsenInfo
    suspend fun setupOnsenData()
}