package com.eugenics.barrier.ui.compose.screens.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eugenics.barrier.ui.compose.theme.BarrierTheme

@Composable
fun DetailDialog(
    title: String = "title"
) {
    AlertDialog(
        onDismissRequest = {},
        dismissButton = {},
        confirmButton = {},
        text = {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = title)
                }
            }
        }
    )
}


@Composable
@Preview
private fun DetailDialogPreview() {
    BarrierTheme {
        DetailDialog()
    }
}