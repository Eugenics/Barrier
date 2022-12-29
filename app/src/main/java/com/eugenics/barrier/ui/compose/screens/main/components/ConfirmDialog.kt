package com.eugenics.barrier.ui.compose.screens.main.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun ConfirmDialog(
    confirmText: String = "Вы действительно хотите удалить запись?",
    onConfirm: () -> Unit = {},
    onDismiss: () -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Отмена")
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Удалить")
            }
        },
        title = { Text(text = "Удалить запись?") },
        text = { Text(text = confirmText) }
    )
}