package com.eugenics.barrier.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.eugenics.barrier.data.dao.PhoneRecordEntity
import com.eugenics.barrier.data.database.AppDatabase
import com.eugenics.barrier.data.database.DataBaseFactory
import com.eugenics.barrier.data.datasource.local.LocalDataSourceFactory
import com.eugenics.barrier.domain.interfaces.IDataSource
import com.eugenics.barrier.domain.model.PhoneRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val dataBase: AppDatabase = DataBaseFactory.buildFake(application.applicationContext)
    private val localDataSource: IDataSource = LocalDataSourceFactory.build(database = dataBase)

    private val scope = viewModelScope
    private val dispatcher = Dispatchers.IO

    private val _records: MutableStateFlow<List<PhoneRecord>> = MutableStateFlow(listOf())
    val records: StateFlow<List<PhoneRecord>> = _records

    fun getRecords() {
        scope.launch(dispatcher) {
            addTestData()
            localDataSource.fetchRecords().collect { phoneRecords ->
                if (phoneRecords.isNotEmpty()) {
                    _records.value = phoneRecords
                }
            }
        }
    }

    private fun addTestData() {
        dataBase.dao.insertPhoneRecord(
            record = PhoneRecordEntity(
                id = UUID.randomUUID().toString(),
                name = "Record1",
                phoneNumber = "+79137904055"
            )
        )
        dataBase.dao.insertPhoneRecord(
            record = PhoneRecordEntity(
                id = UUID.randomUUID().toString(),
                name = "Record2",
                phoneNumber = "+79137904053"
            )
        )
        dataBase.dao.insertPhoneRecord(
            record = PhoneRecordEntity(
                id = UUID.randomUUID().toString(),
                name = "Record3",
                phoneNumber = "+7913000000"
            )
        )
    }
}