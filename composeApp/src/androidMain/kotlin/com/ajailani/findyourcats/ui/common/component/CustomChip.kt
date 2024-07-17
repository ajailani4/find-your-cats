package com.ajailani.findyourcats.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun CustomChip(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    text: String
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(color = MaterialTheme.colorScheme.secondary)
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon?.let {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = icon,
                contentDescription = "Chip icon",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }

        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}