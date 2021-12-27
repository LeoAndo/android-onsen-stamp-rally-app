package com.onsenstamprallyapp.data.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.onsenstamprallyapp.data.room.dao.OnsenDao
import com.onsenstamprallyapp.data.room.entity.OnsenEntity

@Database(
    entities = [OnsenEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class OnsenDatabase : RoomDatabase() {
    abstract fun onsenDao(): OnsenDao

    companion object {
        @Volatile
        private var INSTANCE: OnsenDatabase? = null
        fun getInstance(context: Context): OnsenDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context, OnsenDatabase::class.java,
                    "onsen.db"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Log.d("OnsenDatabase", "!!!!onCreate!!!!!!!!!")
                            //pre-populate data
                        }
                    })
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}