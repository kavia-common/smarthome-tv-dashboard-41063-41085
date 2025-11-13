package org.example.app.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// PUBLIC_INTERFACE
@Composable
/** CCTV screen simplified to avoid foundation.layout inline methods. */
fun CctvScreen(onBack: () -> Unit) {
    // Minimal content: a single Surface with a Text title.
    Surface {
        Text(text = "Front Camera", style = MaterialTheme.typography.displayLarge)
    }
}
