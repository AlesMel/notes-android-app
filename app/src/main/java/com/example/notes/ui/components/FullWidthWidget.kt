package com.example.notes.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.notes.R

@Composable
fun CreateWidget(
    modifier: Modifier = Modifier,
    width: Dp = 324.dp,
    height: Dp = 324.dp,
    backgroundColor: Color = colorResource(id = R.color.secondary_lighter),
    title: String,
    content: @Composable () -> Unit
) {
    RoundedRectangleContent(
        content = content, // Pass the provided content lambda
        backgroundColor = backgroundColor,
        title = title,
        modifier = modifier
            .width(width)
            .height(height)
    )
}

@Composable
private fun RoundedRectangleContent(
    content: @Composable () -> Unit,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    cornerRadius: Dp = 16.dp,
    padding: Dp = 16.dp,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .shadow(
                10.dp,
                shape = RoundedCornerShape(cornerRadius),
                spotColor = backgroundColor)
            .background(backgroundColor)
            .padding(padding)

    ) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium,
            color = colorResource(id = R.color.primary),
            maxLines = 2
        )
        content() // Invoke the content lambda here to display the provided content
    }
}

@Preview
@Composable
private fun RoundedRectangleWidgetPreview() {
    CreateWidget(
        title = "Hello, Rounded Rectangle Content!"
    ) {
        // Your content composable here
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
