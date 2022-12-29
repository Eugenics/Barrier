package com.eugenics.barrier.ui.compose.screens.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eugenics.barrier.domain.model.PhoneRecord
import com.eugenics.barrier.ui.compose.theme.BarrierTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordDialog(
    title: String = "Title",
    record: PhoneRecord = PhoneRecord.newEmptyInstance(),
    onConfirm: (record: PhoneRecord) -> Unit = { _ -> },
    onDismiss: () -> Unit = {}
) {
    val recordName = rememberSaveable { mutableStateOf(record.name) }
    val recordPhoneNumber = rememberSaveable { mutableStateOf(record.phoneNumber) }
    val recordRem = rememberSaveable { mutableStateOf(record.rem) }
    val columnState = rememberLazyListState()

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onConfirm(
                    PhoneRecord(
                        id = record.id,
                        name = recordName.value,
                        rem = recordRem.value,
                        phoneNumber = recordPhoneNumber.value
                    )
                )
            }) {
                Text(text = "Сохранить")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Отмена")
            }
        },
        title = {
            Text(text = title)
        },
        text = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                state = columnState
            ) {
                item {
                    OutlinedTextField(
                        value = recordName.value,
                        onValueChange = { recordName.value = it },
                        label = { Text(text = "Имя") },
                        modifier = Modifier.padding(8.dp).fillMaxWidth()
                    )
                }
                item {
                    OutlinedTextField(
                        value = recordRem.value,
                        onValueChange = { recordRem.value = it },
                        label = { Text(text = "Описание") },
                        modifier = Modifier.padding(8.dp).fillMaxWidth()
                    )
                }
                item {
                    OutlinedTextField(
                        value = recordPhoneNumber.value,
                        onValueChange = {
                            if (it.isBlank() || it.length <= 1) {
                                recordPhoneNumber.value = "+7"
                            } else {
                                recordPhoneNumber.value = it
                            }
                        },
                        label = { Text(text = "Телефон") },
                        modifier = Modifier.padding(8.dp).fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                }
            }
        }
    )
}

@Composable
@Preview
private fun RecordDialogPreview() {
    BarrierTheme {
        RecordDialog()
    }
}