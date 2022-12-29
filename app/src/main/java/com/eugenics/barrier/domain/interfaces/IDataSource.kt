package com.eugenics.barrier.domain.interfaces

import com.eugenics.barrier.domain.model.PhoneRecord
import kotlinx.coroutines.flow.Flow

interface IDataSource {
    suspend fun fetchRecords(): Flow<List<PhoneRecord>>
    suspend fun addRecord(record: PhoneRecord)
    suspend fun editRecord(record: PhoneRecord)
    suspend fun deleterRecord(record: PhoneRecord)
}