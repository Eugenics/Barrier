package com.eugenics.barrier.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.eugenics.barrier.data.database.AppDatabase
import com.eugenics.barrier.data.database.DataBaseFactory
import com.eugenics.barrier.data.datasource.local.LocalDataSourceFactory
import com.eugenics.barrier.domain.interfaces.IDataSource
import com.eugenics.barrier.domain.model.PhoneRecord
import com.eugenics.barrier.ui.util.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val dataBase: AppDatabase = DataBaseFactory.build(application.applicationContext)
    private val localDataSource: IDataSource = LocalDataSourceFactory.build(database = dataBase)

    private val scope = viewModelScope
    private val dispatcher = Dispatchers.IO

    private val _records: MutableStateFlow<List<PhoneRecord>> = MutableStateFlow(listOf())
    val records: StateFlow<List<PhoneRecord>> = _records

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    fun getRecords() {
        scope.launch(dispatcher) {
            _uiState.value = UiState.Loading
            localDataSource.fetchRecords().collect { phoneRecords ->
                if (phoneRecords.isNotEmpty()) {
                    _records.value = phoneRecords
                }
                _uiState.value = UiState.List
            }
        }
    }

    fun newRecord(record: PhoneRecord) {
        scope.launch(dispatcher) {
            localDataSource.addRecord(record = record)
            _uiState.value = UiState.List
        }
    }

    fun editRecord(record: PhoneRecord) {
        scope.launch(dispatcher) {
            localDataSource.editRecord(record = record)
            _uiState.value = UiState.List
        }
    }

    fun setUiState(uiState: UiState) {
        _uiState.value = uiState
    }

    fun deleteRecord(record: PhoneRecord) {
        scope.launch(dispatcher) {
            localDataSource.deleterRecord(record = record)
        }
    }

    companion object {
        const val TAG = "Main_ViewModel"

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val application: Application = checkNotNull(extras[APPLICATION_KEY])
                return MainViewModel(application = application) as T
            }
        }
    }
}