package ru.gelder.testkobweb

import com.varabyte.kobweb.compose.ui.graphics.Color

data class ColorScheme(
    val primary: Color.Rgb = Color.rgb(0x0064F9),
    val secondary1: Color.Rgb = Color.rgb(0x2F67BB),
    val secondary2: Color.Rgb = Color.rgb(0x0041A2),
    val secondary3: Color.Rgb = Color.rgb(0x3F8BFC),
    val secondary4: Color.Rgb = Color.rgb(0x71A9FC),
    val accent: Color.Rgb = Color.rgb(0xFFA100),
    val accent2: Color.Rgb = Color.rgb(0xFFB840),
)

object SitePalette {
    val theme = ColorScheme()
}