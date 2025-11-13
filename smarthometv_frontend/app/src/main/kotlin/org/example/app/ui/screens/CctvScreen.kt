package org.example.app.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// PUBLIC_INTERFACE
@Composable
/** CCTV screen simplified to avoid foundation.layout inline methods.
 * Displays a minimal title within a Surface without using Column/Row/Box/Spacer or padding helpers.
 */
fun CctvScreen(onBack: () -> Unit) {
    // Minimal content: a single Surface with a Text title. No Modifier.fillMax*, padding, or Arrangement/Alignment.
    Surface {
        Text(
            text = "Front Camera",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
