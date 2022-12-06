package com.eugenics.barrier.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eugenics.barrier.ui.compose.screens.main.MainScreen
import com.eugenics.barrier.ui.compose.theme.BarrierTheme
import com.eugenics.barrier.ui.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = MainViewModel(application = application)

        setContent {
            BarrierTheme {
                MainScreen(
                    records = mainViewModel.records,
                    getRecords = { mainViewModel.getRecords() }
                )
            }
        }
    }
}