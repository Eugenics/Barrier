package com.eugenics.barrier.ui.compose.screens.main.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Rationale(
    onRequestPermission: () -> Unit
) {
    val rationale = "Эти разрешения очень важны для приложения."

    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = "Запрос разрешений")
        },
        text = {
            Text(rationale)
        },
        confirmButton = {
            Button(onClick = onRequestPermission) {
                Text("OK")
            }
        }
    )
}