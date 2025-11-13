package org.example.app.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.example.app.model.Device

// PUBLIC_INTERFACE
@Composable
/** Home dashboard simplified to avoid foundation.layout inline methods.
 * Pure Surface + Text only; no Column/Row/Box/Spacer, no padding/fillMax or Arrangement/Alignment APIs.
 */
fun HomeScreen(
    onDeviceSelected: (Device) -> Unit
) {
    Surface {
        Text(
            text = "Smart Home",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
