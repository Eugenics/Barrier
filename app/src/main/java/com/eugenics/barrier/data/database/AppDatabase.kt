package com.eugenics.barrier.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eugenics.barrier.data.dao.Dao
import com.eugenics.barrier.data.dao.PhoneRecordEntity

@Database(entities = [PhoneRecordEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: Dao
}