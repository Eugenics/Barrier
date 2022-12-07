package com.eugenics.barrier.ui.compose.screens.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eugenics.barrier.ui.compose.theme.BarrierTheme

@Composable
fun RecordRow(
    titleText: String = "Sample Title",
    subTitleText: String = "Sample Subtitle",
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical =4.dp)
            .clickable { onClick() }
//            .background(
//                color = MaterialTheme.colorScheme.background,
//                shape = MaterialTheme.shapes.medium
//            )
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                shape = MaterialTheme.shapes.medium
            )
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .align(Alignment.CenterVertically)
                .wrapContentWidth(align = Alignment.Start)
        ) {
            Text(
                text = titleText,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp)
            )
            Text(
                text = subTitleText,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                .wrapContentWidth(align = Alignment.End)
        ) {
            FilledTonalButton(
                onClick = {},
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "...",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
@Preview()
private fun RecordRowPreview() {
    BarrierTheme {
        RecordRow()
    }
}