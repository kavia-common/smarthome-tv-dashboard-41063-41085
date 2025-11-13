package org.example.app.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Power
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.ui.graphics.vector.ImageVector

/** Device model for SmartHomeTV. */
data class Device(
    val id: Int,
    val name: String,
    var status: String,
    val icon: ImageVector,
    val type: DeviceType
)

/** Dummy device list for demo. */
val dummyDevices: List<Device> = listOf(
    Device(1, "Living Room Light", "ON", Icons.Filled.Lightbulb, DeviceType.LIGHT),
    Device(2, "Bedroom AC", "22°C", Icons.Filled.AcUnit, DeviceType.AC),
    Device(3, "Door Lock", "Locked", Icons.Filled.Lock, DeviceType.LOCK),
    Device(4, "Front Camera", "Recording", Icons.Filled.CameraAlt, DeviceType.CAMERA),
    Device(5, "Kitchen Plug", "OFF", Icons.Filled.Power, DeviceType.PLUG),
    Device(6, "Room Temperature", "27°C", Icons.Filled.Thermostat, DeviceType.TEMPERATURE)
)
