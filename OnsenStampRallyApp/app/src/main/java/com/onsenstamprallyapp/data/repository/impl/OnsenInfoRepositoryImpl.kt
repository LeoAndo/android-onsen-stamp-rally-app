package com.onsenstamprallyapp.data.repository.impl

import android.util.Log
import com.onsenstamprallyapp.data.OnsenData
import com.onsenstamprallyapp.data.dbCall
import com.onsenstamprallyapp.data.repository.OnsenInfoRepository
import com.onsenstamprallyapp.data.room.dao.OnsenDao
import com.onsenstamprallyapp.data.room.entity.toOnsenInfo
import com.onsenstamprallyapp.data.room.entity.toOnsenInfoDetail
import com.onsenstamprallyapp.data.room.entity.toOnsenInfoList
import com.onsenstamprallyapp.model.OnsenInfo
import com.onsenstamprallyapp.model.OnsenInfoDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class OnsenInfoRepositoryImpl @Inject constructor(
    private val dao: OnsenDao
) : OnsenInfoRepository {
    override fun observeOnsenInfoList(): Flow<List<OnsenInfo>> {
        return dao.selectAllOnsenList().map { it.toOnsenInfoList() }.flowOn(Dispatchers.IO)
    }

    override suspend fun getAllOnsenInfoList(): List<OnsenInfo> {
        return dbCall {
            dao.selectAllOnsenList2().map {
                it.toOnsenInfo()
            }
        }
    }

    override suspend fun getStampedOnsenInfoList(): List<OnsenInfo> {
        return dbCall {
            dao.selectStampedOnsenList().map {
                it.toOnsenInfo()
            }
        }
    }

    override suspend fun getNoStampedOnsenInfoList(): List<OnsenInfo> {
        return dbCall {
            dao.selectNoStampOnsenList().map {
                it.toOnsenInfo()
            }
        }
    }

    override suspend fun getOnsenInfoDetail(id: Int): OnsenInfoDetail {
        return dbCall { dao.selectOnsenInfo(id).toOnsenInfoDetail() }
    }

    override suspend fun setupOnsenData() {
        dbCall {
            val onsenInfoCount = dao.selectOnsenInfoCount()
            if (onsenInfoCount != 0) {
                Log.d("OnsenInfoRepositoryImpl", "onsenInfoCount != 0")
                return@dbCall
            }
            Log.d("OnsenInfoRepositoryImpl", "setupOnsenData!!!!!!")
            dao.insertOnsenData(*OnsenData.arrayData)
        }
    }

    override suspend fun updateStampStatus(id: Int, isStamped: Boolean) {
        dbCall {
            val entity = dao.selectOnsenInfo(id).copy(isStamped = isStamped)
            dao.updateOnsenData(entity)
        }
    }
}