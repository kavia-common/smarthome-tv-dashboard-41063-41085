package org.example.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
/** Stateless Focusable TV card with minimal content to avoid IR inline issues.
 * Uses only Material3 Text inside Card; avoids foundation.layout helpers entirely.
 */
fun FocusableCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    focused: Boolean = false,
    onClick: () -> Unit
) {
    // Use primitive values and simple modifier chain; avoid state-capturing lambdas and layout helpers.
    val scale = if (focused) 1.05f else 1.0f
    val borderColor: Color = if (focused) Gold else Color.Transparent
    val elevation = if (focused) 16.dp else 4.dp

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
        // Single text block; no Column/Row/Box or padding helpers to avoid inline lookups.
        Text(
            text = "$title • $subtitle",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
