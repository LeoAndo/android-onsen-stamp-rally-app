package com.onsenstamprallyapp.domain.repository

import com.onsenstamprallyapp.data.SafeResult
import com.onsenstamprallyapp.domain.model.OnsenInfo
import com.onsenstamprallyapp.domain.model.OnsenInfoDetail
import kotlinx.coroutines.flow.Flow

interface OnsenInfoRepository {
    fun observeOnsenInfoList(): Flow<List<OnsenInfo>>
    suspend fun getAllOnsenInfoList(): SafeResult<List<OnsenInfo>>
    suspend fun getStampedOnsenInfoList(): SafeResult<List<OnsenInfo>>
    suspend fun getNoStampedOnsenInfoList(): SafeResult<List<OnsenInfo>>
    suspend fun getOnsenInfoDetail(id: Int): SafeResult<OnsenInfoDetail>
    suspend fun setupOnsenData()
    suspend fun updateStampStatus(id: Int, isStamped: Boolean)
}