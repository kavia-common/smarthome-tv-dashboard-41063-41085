package org.example.app.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.example.app.ui.theme.Gold

// PUBLIC_INTERFACE
@Composable
/** Focusable TV card with scale, glow, and gold outline on focus. */
fun FocusableCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var focused by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (focused) 1.06f else 1.0f, label = "scale")
    val borderColor by animateColorAsState(targetValue = if (focused) Gold else Color.Transparent, label = "border")
    val elevation = if (focused) 16.dp else 4.dp
    val interaction = remember { MutableInteractionSource() }

    val cardModifier = modifier
        .onFocusChanged { focused = it.isFocused }
        .scale(scale)
        .shadow(elevation, RoundedCornerShape(16.dp), clip = false)
        .border(BorderStroke(1.5.dp, borderColor), RoundedCornerShape(16.dp))
        .focusable(enabled = true, interactionSource = interaction)

    Card(
        onClick = onClick,
        modifier = cardModifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(PaddingValues(horizontal = 20.dp, vertical = 18.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(54.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(12.dp))
            Text(text = title, style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(6.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f)
            )
        }
    }
}
