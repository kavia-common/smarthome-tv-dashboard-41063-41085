package org.example.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.example.app.ui.screens.CctvScreen
import org.example.app.ui.screens.DeviceDetailScreen
import org.example.app.ui.screens.HomeScreen

// PUBLIC_INTERFACE
@Composable
/** NavHost for SmartHomeTV:
 * - Routes: home, deviceDetail/{id}, cctv
 * - Passes deviceId as Int argument to DeviceDetail.
 */
fun AppNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onDeviceSelected = { device ->
                    if (device.type.name == "CAMERA") {
                        navController.navigate("cctv")
                    } else {
                        navController.navigate("deviceDetail/${device.id}")
                    }
                }
            )
        }
        composable(
            route = "deviceDetail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DeviceDetailScreen(
                deviceId = id,
                onBack = { navController.popBackStack() },
                onNavigateToCctv = { navController.navigate("cctv") }
            )
        }
        composable("cctv") {
            CctvScreen(onBack = { navController.popBackStack() })
        }
    }
}
