package org.example.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.app.model.Device
import org.example.app.model.dummyDevices
import org.example.app.ui.components.FocusableCard

// PUBLIC_INTERFACE
@Composable
/** Home dashboard with 3-column grid of focusable device cards. */
fun HomeScreen(
    onDeviceSelected: (Device) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = "Smart Home",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(Modifier.height(18.dp))
        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )
        Spacer(Modifier.height(28.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(22.dp),
            horizontalArrangement = Arrangement.spacedBy(22.dp),
            contentPadding = PaddingValues(bottom = 48.dp)
        ) {
            itemsIndexed(dummyDevices, key = { _, item -> item.id }) { index, device ->
                // Simple heuristic: mark first item as focused by default; TV DPAD focus will move naturally
                val focused = index == 0
                FocusableCard(
                    title = device.name,
                    subtitle = device.status,
                    icon = device.icon,
                    focused = focused,
                    onClick = { onDeviceSelected(device) }
                )
            }
        }
    }
}
