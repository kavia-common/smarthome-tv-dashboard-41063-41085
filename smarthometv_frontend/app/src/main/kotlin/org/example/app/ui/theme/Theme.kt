package org.example.app.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush

val DarkLuxuryColorScheme: ColorScheme = darkColorScheme(
    primary = Gold,
    onPrimary = Black,
    secondary = Gold,
    onSecondary = Black,
    background = Black,
    surface = DarkGray,
    onSurface = TextPrimary,
    error = ErrorRed,
    onError = Black
)

// PUBLIC_INTERFACE
@Composable
/** App-level theme wrapper using Dark Luxury palette for TV. */
fun SmartHomeTVTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkLuxuryColorScheme,
        typography = TypographyTV,
        shapes = ShapesTV,
        content = content
    )
}

/** Convenience gradient brush for premium backgrounds. */
val PremiumGradient: Brush
    get() = Brush.verticalGradient(
        colors = listOf(Black, DarkGray)
    )
