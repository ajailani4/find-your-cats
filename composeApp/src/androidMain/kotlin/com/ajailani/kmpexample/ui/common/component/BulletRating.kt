package com.ajailani.kmpexample.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun BulletRating(
    modifier: Modifier = Modifier,
    rating: Int
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(10.dp)
                    .background(
                        if (it <= rating - 1) {
                            MaterialTheme.colorScheme.primary
                        } else MaterialTheme.colorScheme.surfaceDim
                    )
            )

            if (it != 5) Spacer(modifier = Modifier.width(5.dp))
        }
    }
}