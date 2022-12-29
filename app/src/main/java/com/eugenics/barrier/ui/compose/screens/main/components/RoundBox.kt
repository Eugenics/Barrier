package com.eugenics.barrier.ui.compose.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eugenics.barrier.ui.compose.theme.BarrierTheme

@Composable
fun RoundBoxWithText(
    modifier: Modifier = Modifier,
    text: String = "RoundTextBox",
    size: Dp = 25.dp
) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .size(size)
            .clip(shape = CircleShape)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = text.first().toString(),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
    }
}

@Composable
@Preview
private fun RoundBoxWithTextPreview() {
    BarrierTheme {
        RoundBoxWithText()
    }
}
