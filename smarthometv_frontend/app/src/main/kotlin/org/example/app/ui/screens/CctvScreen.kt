package org.example.app.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.font.FontWeight
import org.example.app.ui.theme.ErrorRed
import org.example.app.ui.theme.Gold
import org.example.app.ui.theme.PremiumGradient

// PUBLIC_INTERFACE
@Composable
/** CCTV screen with placeholder video, recording badge and back. */
fun CctvScreen(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PremiumGradient)
            .padding(32.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Text(text = "Front Camera", style = MaterialTheme.typography.displayLarge)
            Spacer(Modifier.height(24.dp))
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.dp, Gold),
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .weight(1f, fill = false)
            ) {
                // Placeholder video box
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
                    RecordingBadge()
                }
            }
            Spacer(Modifier.height(24.dp))
            FocusableBackButton(text = "Back", onClick = onBack)
        }
    }
}

@Composable
private fun RecordingBadge() {
    Surface(
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f),
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.dp, Gold),
        modifier = Modifier.padding(12.dp)
    ) {
        Text(
            text = "● Recording",
            color = ErrorRed,
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Composable
private fun FocusableBackButton(text: String, onClick: () -> Unit) {
    // Avoid remember/onFocusChanged to prevent inline IR issues. Use static button styling.
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Text(text = text, style = MaterialTheme.typography.headlineMedium)
    }
}
