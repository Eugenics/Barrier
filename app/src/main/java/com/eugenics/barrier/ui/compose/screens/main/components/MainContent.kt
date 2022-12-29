package com.eugenics.barrier.ui.compose.screens.main.components

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.eugenics.barrier.domain.model.PhoneRecord
import com.eugenics.barrier.ui.util.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    uiState: UiState = UiState.Loading,
    setUiState: (uiState: UiState) -> Unit = { _ -> },
    records: List<PhoneRecord> = listOf(),
    onRecordEdit: (record: PhoneRecord) -> Unit = { _ -> },
    onRecordDelete: (record: PhoneRecord) -> Unit = { _ -> }
) {
    val record = rememberSaveable { mutableStateOf(PhoneRecord.newEmptyInstance()) }

    val showConfirmDialog = rememberSaveable { mutableStateOf(false) }

    if (uiState in listOf(UiState.New, UiState.Edit)) {
        RecordDialog(
            title = "Редактирование",
            record = record.value,
            onConfirm = onRecordEdit,
            onDismiss = { setUiState(UiState.List) }
        )
    }

    if (showConfirmDialog.value) {
        ConfirmDialog(
            onConfirm = {
                onRecordDelete(record.value)
                showConfirmDialog.value = false
            },
            onDismiss = { showConfirmDialog.value = false }
        )
    }

    Scaffold(
        topBar = {},
        bottomBar = {},
        floatingActionButton = {
            MainFab(onClick = {
                record.value = PhoneRecord.newEmptyInstance()
                setUiState(UiState.New)
            })
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            val lazyListState = rememberLazyListState()
            val context = LocalContext.current

            LazyColumn(
//                columns = GridCells.Adaptive(minSize = 150.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 8.dp),
                state = lazyListState
            ) {
                items(
                    items = records,
                    key = { record -> record.id }
                ) { phoneRecord ->
                    RecordRow(
                        titleText = phoneRecord.name,
                        subTitleText = phoneRecord.rem,
                        onEdit = {
                            record.value = phoneRecord
                            setUiState(UiState.Edit)
                        },
                        onClick = {
                            val intent = Intent(
                                Intent.ACTION_CALL,
                                "tel:${phoneRecord.phoneNumber}".toUri()
                            )
                            context.startActivity(intent)
                        },
                        onDelete = {
                            record.value = phoneRecord
                            showConfirmDialog.value = true
                        }
                    )
                }
            }
        }
    }
}