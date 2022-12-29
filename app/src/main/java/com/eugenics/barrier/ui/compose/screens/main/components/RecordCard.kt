package com.eugenics.barrier.ui.compose.screens.main.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.eugenics.barrier.ui.compose.theme.BarrierTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecordCard(
    titleText: String = "Sample Title",
    subTitleText: String = "Sample Subtitle",
    onEdit: () -> Unit = {},
    onClick: () -> Unit = {}
) {
    val offsetX = rememberSaveable { mutableStateOf(0f) }
    Card(
//        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .offset { IntOffset(offsetX.value.toInt(), 0) }
            .combinedClickable(
                onClick = onClick,
                onLongClick = onEdit
            )
            .padding(10.dp)
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    val newOffset = offsetX.value + delta
                    if (newOffset < 0f) {
                        offsetX.value = 0f
                    } else {
                        offsetX.value = newOffset
                    }
                }
            )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                RoundBoxWithText(
                    text = titleText,
                    size = 30.dp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                IconButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = onEdit
                ) {
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = null
                    )
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = titleText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                style = MaterialTheme.typography.titleLarge
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = subTitleText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_NO)
private fun PreviewRecordCard() {
    BarrierTheme {
        RecordCard()
    }
}