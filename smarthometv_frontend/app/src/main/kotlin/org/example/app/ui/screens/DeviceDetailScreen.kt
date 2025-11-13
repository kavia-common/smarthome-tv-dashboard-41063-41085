package org.example.app.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Power
import androidx.compose.material.icons.filled.Remove
import androidx.compose.ui.text.style.TextAlign
import org.example.app.model.Device
import org.example.app.model.DeviceType
import org.example.app.model.dummyDevices
import org.example.app.ui.theme.Gold
import org.example.app.ui.theme.PremiumGradient

// PUBLIC_INTERFACE
@Composable
/** Device Detail screen with premium background and large TV-friendly actions. */
fun DeviceDetailScreen(
    deviceId: Int,
    onBack: () -> Unit,
    onNavigateToCctv: () -> Unit
) {
    val device = remember(deviceId) { dummyDevices.firstOrNull { it.id == deviceId } } ?: return

    // Premium background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PremiumGradient)
            .padding(32.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = device.name, style = MaterialTheme.typography.displayLarge)
            Spacer(Modifier.height(16.dp))
            Icon(
                imageVector = device.icon,
                contentDescription = device.name,
                modifier = Modifier.size(96.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(18.dp))
            StatusPill(text = device.status)

            Spacer(Modifier.height(36.dp))

            when (device.type) {
                DeviceType.LIGHT, DeviceType.PLUG -> {
                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        FocusableActionButton(
                            text = if (device.status.uppercase() == "ON") "Turn OFF" else "Turn ON",
                            iconTinted = Icons.Filled.Power
                        ) {
                            device.status = if (device.status.uppercase() == "ON") "OFF" else "ON"
                        }
                    }
                }
                DeviceType.LOCK -> {
                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        FocusableActionButton(
                            text = if (device.status.contains("Locked", true)) "Unlock" else "Lock",
                            iconTinted = if (device.status.contains("Locked", true)) Icons.Filled.LockOpen else Icons.Filled.Lock
                        ) {
                            device.status = if (device.status.contains("Locked", true)) "Unlocked" else "Locked"
                        }
                    }
                }
                DeviceType.AC, DeviceType.TEMPERATURE -> {
                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        FocusableActionButton(text = "Decrease", iconTinted = Icons.Filled.Remove) {
                            val value = device.status.filter { it.isDigit() }.toIntOrNull() ?: 0
                            device.status = "${kotlin.math.max(0, value - 1)}°C"
                        }
                        FocusableActionButton(text = "Increase", iconTinted = Icons.Filled.Add) {
                            val value = device.status.filter { it.isDigit() }.toIntOrNull() ?: 0
                            device.status = "${value + 1}°C"
                        }
                    }
                }
                DeviceType.CAMERA -> {
                    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                        FocusableActionButton(text = "View CCTV", iconTinted = Icons.Filled.CameraAlt) {
                            onNavigateToCctv()
                        }
                    }
                }
            }
        }

        // Back button bottom-left
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
        ) {
            FocusableOutlinedGoldButton(text = "Back") { onBack() }
        }
    }
}

@Composable
private fun StatusPill(text: String) {
    Surface(
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f),
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.dp, Gold)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun FocusableOutlinedGoldButton(text: String, onClick: () -> Unit) {
    // Avoid remember/onFocusChanged/animations to prevent inline IR issues.
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)),
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(text, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
private fun FocusableActionButton(text: String, iconTinted: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    // Avoid focus state and animations in modifiers to prevent IR inline issues.
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Icon(imageVector = iconTinted, contentDescription = text, modifier = Modifier.padding(end = 12.dp))
        Text(text = text, style = MaterialTheme.typography.headlineMedium)
    }
}
