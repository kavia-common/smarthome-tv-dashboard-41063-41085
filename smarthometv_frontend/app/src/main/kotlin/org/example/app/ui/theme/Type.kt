package org.example.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val TypographyTV = Typography(
    displayLarge = TextStyle(fontSize = 42.sp, fontWeight = FontWeight.Bold),
    headlineLarge = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.SemiBold),
    headlineMedium = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Medium),
    bodyLarge = TextStyle(fontSize = 22.sp),
    bodyMedium = TextStyle(fontSize = 18.sp),
    labelLarge = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
)
