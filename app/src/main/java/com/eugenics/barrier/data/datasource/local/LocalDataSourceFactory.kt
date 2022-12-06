package com.eugenics.barrier.data.datasource.local

import com.eugenics.barrier.data.database.AppDatabase
import com.eugenics.barrier.domain.interfaces.IDataSource

object LocalDataSourceFactory {
    fun build(database: AppDatabase): IDataSource = LocalDataSource(database = database)
}