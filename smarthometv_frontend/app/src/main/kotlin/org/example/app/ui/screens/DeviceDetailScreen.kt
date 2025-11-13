package org.example.app.ui.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.example.app.model.dummyDevices

// PUBLIC_INTERFACE
@Composable
/** Device Detail screen simplified to avoid foundation.layout inline methods. */
fun DeviceDetailScreen(
    deviceId: Int,
    onBack: () -> Unit,
    onNavigateToCctv: () -> Unit
) {
    val device = dummyDevices.firstOrNull { it.id == deviceId } ?: return
    Surface {
        Text(text = device.name, style = MaterialTheme.typography.displayLarge)
    }
}
