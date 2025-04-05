package org.poc

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlin.math.max
import kotlin.math.min

fun dynamicLightColorScheme(seedColor: Color): ColorScheme {
    val hsl = seedColor.toHSL()
    
    val primary = seedColor
    val onPrimary = getContrastColor(primary)
    val primaryContainer = adjustLightness(primary, 0.9f)
    val onPrimaryContainer = adjustLightness(primary, 0.1f)
    
    val secondary = adjustHue(primary, 30f)
    val onSecondary = getContrastColor(secondary)
    val secondaryContainer = adjustLightness(secondary, 0.9f)
    val onSecondaryContainer = adjustLightness(secondary, 0.1f)
    
    val tertiary = adjustHue(primary, 60f)
    val onTertiary = getContrastColor(tertiary)
    val tertiaryContainer = adjustLightness(tertiary, 0.9f)
    val onTertiaryContainer = adjustLightness(tertiary, 0.1f)

    return lightColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer
    )
}

fun dynamicDarkColorScheme(seedColor: Color): ColorScheme {
    val hsl = seedColor.toHSL()
    
    val primary = adjustLightness(seedColor, 0.8f)
    val onPrimary = getContrastColor(primary)
    val primaryContainer = adjustLightness(primary, 0.2f)
    val onPrimaryContainer = adjustLightness(primary, 0.9f)
    
    val secondary = adjustHue(primary, 30f)
    val onSecondary = getContrastColor(secondary)
    val secondaryContainer = adjustLightness(secondary, 0.2f)
    val onSecondaryContainer = adjustLightness(secondary, 0.9f)
    
    val tertiary = adjustHue(primary, 60f)
    val onTertiary = getContrastColor(tertiary)
    val tertiaryContainer = adjustLightness(tertiary, 0.2f)
    val onTertiaryContainer = adjustLightness(tertiary, 0.9f)

    return darkColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer
    )
}

private fun Color.toHSL(): FloatArray {
    val r = red
    val g = green
    val b = blue
    
    val max = max(max(r, g), b)
    val min = min(min(r, g), b)
    val delta = max - min
    
    var h = when {
        delta == 0f -> 0f
        max == r -> ((g - b) / delta) % 6f
        max == g -> ((b - r) / delta) + 2f
        else -> ((r - g) / delta) + 4f
    }
    h = (h * 60f + 360f) % 360f
    
    val l = (max + min) / 2f
    
    val s = when {
        delta == 0f -> 0f
        else -> delta / (1f - kotlin.math.abs(2f * l - 1f))
    }
    
    return floatArrayOf(h, s, l)
}

private fun adjustHue(color: Color, amount: Float): Color {
    val hsl = color.toHSL()
    hsl[0] = (hsl[0] + amount) % 360f
    return Color.hsv(hsl[0], hsl[1], hsl[2])
}

private fun adjustLightness(color: Color, targetLightness: Float): Color {
    val hsl = color.toHSL()
    hsl[2] = targetLightness
    return Color.hsv(hsl[0], hsl[1], hsl[2])
}

private fun getContrastColor(color: Color): Color {
    val luminance = (0.299 * color.red + 0.587 * color.green + 0.114 * color.blue)
    return if (luminance > 0.5f) Color.Black else Color.White
} 