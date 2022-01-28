package com.onsenstamprallyapp.data.repository.impl

import android.util.Log
import com.onsenstamprallyapp.data.OnsenData
import com.onsenstamprallyapp.data.SafeResult
import com.onsenstamprallyapp.data.safeCall
import com.onsenstamprallyapp.domain.repository.OnsenInfoRepository
import com.onsenstamprallyapp.data.room.dao.OnsenDao
import com.onsenstamprallyapp.data.room.entity.toOnsenInfo
import com.onsenstamprallyapp.data.room.entity.toOnsenInfoDetail
import com.onsenstamprallyapp.data.room.entity.toOnsenInfoList
import com.onsenstamprallyapp.domain.di.IoDispatcher
import com.onsenstamprallyapp.domain.model.OnsenInfo
import com.onsenstamprallyapp.domain.model.OnsenInfoDetail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class OnsenInfoRepositoryImpl @Inject constructor(
    private val dao: OnsenDao,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : OnsenInfoRepository {
    override fun observeOnsenInfoList(): Flow<List<OnsenInfo>> {
        return dao.selectAllOnsenList().map { it.toOnsenInfoList() }.flowOn(Dispatchers.IO)
    }

    override suspend fun getAllOnsenInfoList(): SafeResult<List<OnsenInfo>> {
        return safeCall(dispatcher) {
            dao.selectAllOnsenList2().map {
                it.toOnsenInfo()
            }
        }
    }

    override suspend fun getStampedOnsenInfoList(): SafeResult<List<OnsenInfo>> {
        return safeCall(dispatcher) {
            dao.selectStampedOnsenList().map {
                it.toOnsenInfo()
            }
        }
    }

    override suspend fun getNoStampedOnsenInfoList(): SafeResult<List<OnsenInfo>> {
        return safeCall(dispatcher) {
            dao.selectNoStampOnsenList().map {
                it.toOnsenInfo()
            }
        }
    }

    override suspend fun getOnsenInfoDetail(id: Int): SafeResult<OnsenInfoDetail> {
        return safeCall(dispatcher) { dao.selectOnsenInfo(id).toOnsenInfoDetail() }
    }

    override suspend fun setupOnsenData() {
        safeCall(dispatcher) {
            val onsenInfoCount = dao.selectOnsenInfoCount()
            if (onsenInfoCount != 0) {
                Log.d("OnsenInfoRepositoryImpl", "onsenInfoCount != 0")
                return@safeCall
            }
            Log.d("OnsenInfoRepositoryImpl", "setupOnsenData!!!!!!")
            dao.insertOnsenData(*OnsenData.arrayData)
        }
    }

    override suspend fun updateStampStatus(id: Int, isStamped: Boolean) {
        safeCall(dispatcher) {
            val entity = dao.selectOnsenInfo(id).copy(isStamped = isStamped)
            dao.updateOnsenData(entity)
        }
    }
}