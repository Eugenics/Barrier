package com.eugenics.barrier.domain.interfaces

import com.eugenics.barrier.domain.model.PhoneRecord
import kotlinx.coroutines.flow.Flow

interface IDataSource {
    suspend fun fetchRecords(): Flow<List<PhoneRecord>>
}