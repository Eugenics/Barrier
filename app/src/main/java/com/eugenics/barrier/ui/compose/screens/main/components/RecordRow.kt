package com.eugenics.barrier.ui.compose.screens.main.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eugenics.barrier.R
import com.eugenics.barrier.ui.compose.theme.BarrierTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecordRow(
    titleText: String = "Sample Title",
    subTitleText: String = "Sample Subtitle",
    onEdit: () -> Unit = {},
    onClick: () -> Unit = {},
    onDelete: () -> Unit = {}
) {
    val rowState = rememberSaveable { mutableStateOf(false) }

    val animatedBorder = remember { Animatable(initialValue = 5f) }

    if (rowState.value) {
        LaunchedEffect(rowState) {
            animatedBorder.animateTo(
                targetValue = 0.5f,
                animationSpec = repeatable(
                    animation = tween(
                        durationMillis = 500,
                        easing = LinearEasing,
                        delayMillis = 0
                    ),
                    iterations = 1,
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    } else {
        LaunchedEffect(rowState) {
            animatedBorder.animateTo(
                targetValue = 5f,
                animationSpec = repeatable(
                    animation = tween(
                        durationMillis = 500,
                        easing = LinearEasing,
                        delayMillis = 0
                    ),
                    iterations = 1,
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 4.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .combinedClickable(
                onClick = onClick,
                onLongClick = onEdit
            )
            .border(
                width = Dp(animatedBorder.value),
                shape = MaterialTheme.shapes.medium,
                color = if (rowState.value) MaterialTheme.colorScheme.tertiary
                else Color.Transparent
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .align(alignment = Alignment.CenterVertically)
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = CircleShape)
                            .background(color = MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = titleText.first().toString(),
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(2.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(3f)
                        .align(Alignment.CenterVertically)
                        .wrapContentWidth(align = Alignment.Start)
                ) {
                    Text(
                        text = titleText,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                    )
                    Text(
                        text = subTitleText,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .align(Alignment.CenterVertically)
                        .wrapContentWidth(align = Alignment.End)
                ) {
                    IconButton(
                        onClick = {
                            rowState.value = !rowState.value
                        },
                        modifier = Modifier
                            .padding(10.dp)
                    ) {
                        Icon(
                            painter = if (rowState.value) {
                                painterResource(R.drawable.ic_expand_less)
                            } else {
                                painterResource(R.drawable.ic_expand_more)
                            },
                            contentDescription = null
                        )
                    }
                }
            }
            AnimatedVisibility(
                visible = rowState.value,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = onDelete,
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = null
                        )
                    }

                    IconButton(
                        onClick = onEdit,
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = null
                        )
                    }
                }
            }

        }
    }
}

@Composable
@Preview(name = "Light", uiMode = UI_MODE_NIGHT_NO)
private fun RecordRowPreviewLight() {
    BarrierTheme {
        RecordRow()
    }
}


@Composable
@Preview(name = "Night", uiMode = UI_MODE_NIGHT_YES)
private fun RecordRowPreviewNight() {
    BarrierTheme {
        RecordRow()
    }
}