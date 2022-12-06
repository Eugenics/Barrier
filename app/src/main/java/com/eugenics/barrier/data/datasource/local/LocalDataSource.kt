package com.eugenics.barrier.data.datasource.local

import com.eugenics.barrier.data.database.AppDatabase
import com.eugenics.barrier.domain.interfaces.IDataSource
import com.eugenics.barrier.domain.model.PhoneRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataSource(private val database: AppDatabase) : IDataSource {
    override suspend fun fetchRecords(): Flow<List<PhoneRecord>> =
        database.dao.fetchPhoneRecords().map {
            it.map { entity ->
                entity.mapToModel()
            }
        }
}