package com.ajailani.kmpexample.ui.common.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ajailani.kmpexample.util.CatAttributeType

@Composable
fun CatAttribute(
    modifier: Modifier = Modifier,
    key: String,
    value: CatAttributeType,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.weight(4f),
            text = key,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.titleMedium
        )

        Box(modifier = Modifier.weight(6f)) {
            when (value) {
                is CatAttributeType.Text -> {
                    Text(
                        text = value.text,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                is CatAttributeType.Rating -> {
                    BulletRating(
                        modifier = Modifier.fillMaxHeight(),
                        rating = value.rating
                    )
                }
            }
        }
    }
}