package com.eugenics.barrier.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@androidx.room.Dao
interface Dao {
    @Query("SELECT * FROM phone_records")
    fun fetchPhoneRecords(): Flow<List<PhoneRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoneRecord(record: PhoneRecordEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updatePhoneRecord(record: PhoneRecordEntity)

    @Delete
    fun deletePhoneRecord(record: PhoneRecordEntity)
}