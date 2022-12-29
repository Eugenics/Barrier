package com.eugenics.barrier.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.core.view.WindowCompat
import com.eugenics.barrier.ui.compose.screens.main.MainScreen
import com.eugenics.barrier.ui.compose.theme.BarrierTheme
import com.eugenics.barrier.ui.util.UiState
import com.eugenics.barrier.ui.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels { MainViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BarrierTheme {
                val records = mainViewModel.records.collectAsState()
                val uiState = mainViewModel.uiState.collectAsState()

                LaunchedEffect(null) {
                    mainViewModel.getRecords()
                }

                MainScreen(
                    uiState = uiState.value,
                    setUiState = { state -> mainViewModel.setUiState(uiState = state) },
                    records = records.value,
                    onRecordEdit = { record ->
                        if (uiState.value == UiState.New) {
                            mainViewModel.newRecord(record = record)
                        } else {
                            mainViewModel.editRecord(record = record)
                        }
                    },
                    onRecordDelete = { record ->
                        mainViewModel.deleteRecord(record = record)
                    }
                )
            }
        }
    }
}