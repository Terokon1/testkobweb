package ru.gelder.testkobweb

import com.varabyte.kobweb.compose.ui.graphics.Color

data class ColorScheme(
    val primary: Color.Rgb = Color.rgb(0x3b5bdb),  // Blue color from the design
    val secondary1: Color.Rgb = Color.rgb(0x2F67BB),
    val secondary2: Color.Rgb = Color.rgb(0x0041A2),
    val secondary3: Color.Rgb = Color.rgb(0x3F8BFC),
    val secondary4: Color.Rgb = Color.rgb(0x71A9FC),
    val accent: Color.Rgb = Color.rgb(0xFFA100),
    val accent2: Color.Rgb = Color.rgb(0xFFB840),
    val success: Color.Rgb = Color.rgb(0x4CAF50),   // Green for checkmarks
    val warning: Color.Rgb = Color.rgb(0xFF9800),
    val error: Color.Rgb = Color.rgb(0xF44336),
    val background: Color.Rgb = Color.rgb(0xf5f6fa), // Light gray background
    val surface: Color.Rgb = Color.rgb(0xffffff),    // White surface
    val text: Color.Rgb = Color.rgb(0x1a1a1a),       // Dark text
    val textSecondary: Color.Rgb = Color.rgb(0x666666), // Secondary text
)

object SitePalette {
    val theme = ColorScheme()
}