package org.example.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.example.app.ui.theme.Gold

// PUBLIC_INTERFACE
@Composable
/** Stateless Focusable TV card that renders given focus visuals without local remember. */
fun FocusableCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    focused: Boolean = false,
    onClick: () -> Unit
) {
    val scale = if (focused) 1.0f + 0.05f else 1.0f
    val borderColor: Color = if (focused) Gold else Color.Transparent
    val elevation = if (focused) 16.dp else 4.dp

    // Keep modifier chain minimal to avoid IR inline of many inlined functions together
    val cardModifier = modifier
        .focusTarget()
        .focusable(true)
        .shadow(elevation, RoundedCornerShape(16.dp), clip = false)
        .border(BorderStroke(1.5.dp, borderColor), RoundedCornerShape(16.dp))
        .scale(scale)

    Card(
        onClick = onClick,
        modifier = cardModifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        FocusableCardContent(title = title, subtitle = subtitle, icon = icon)
    }
}

/** Internal content extracted to reduce inline pressure on IR. */
@Composable
private fun FocusableCardContent(title: String, subtitle: String, icon: ImageVector) {
    Column(
        modifier = Modifier.padding(PaddingValues(horizontal = 20.dp, vertical = 18.dp)),
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
