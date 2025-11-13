package org.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.app.navigation.AppNav
import org.example.app.ui.theme.SmartHomeTVTheme

/**
 * MainActivity launches the SmartHomeTV Compose UI and hosts the NavGraph.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartHomeTVTheme {
                Surface(modifier = Modifier) {
                    AppNav()
                }
            }
        }
    }
}
