package com.onsenstamprallyapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.onsenstamprallyapp.data.room.entity.OnsenEntity
import com.onsenstamprallyapp.data.room.entity.TABLE_NAME_ONSEN
import kotlinx.coroutines.flow.Flow

@Dao
internal interface OnsenDao {
    // insert
    @Insert
    suspend fun insertOnsenData(vararg onsenEntity: OnsenEntity)

    // update
    @Update
    suspend fun updateOnsenData(vararg onsenEntity: OnsenEntity)

    // select
    @Query("SELECT * FROM $TABLE_NAME_ONSEN")
    fun selectAllOnsenList(): Flow<List<OnsenEntity>>

    @Query("SELECT * FROM $TABLE_NAME_ONSEN")
    fun selectAllOnsenList2(): List<OnsenEntity>

    @Query("SELECT * FROM $TABLE_NAME_ONSEN WHERE isStamped = 1")
    fun selectStampedOnsenList(): List<OnsenEntity>

    @Query("SELECT * FROM $TABLE_NAME_ONSEN WHERE isStamped = 0")
    fun selectNoStampOnsenList(): List<OnsenEntity>

    @Query("SELECT * FROM $TABLE_NAME_ONSEN WHERE id = :id")
    fun selectOnsenInfo(id: Int): OnsenEntity

    @Query("SELECT count(*) FROM $TABLE_NAME_ONSEN")
    fun selectOnsenInfoCount(): Int

    @Query("SELECT count(*) FROM $TABLE_NAME_ONSEN WHERE isStamped = 1")
    fun selectStampedOnsenCount(): Int

    @Query("SELECT count(*) FROM $TABLE_NAME_ONSEN WHERE isStamped = 0")
    fun selectNoStampOnsenCount(): Int
}