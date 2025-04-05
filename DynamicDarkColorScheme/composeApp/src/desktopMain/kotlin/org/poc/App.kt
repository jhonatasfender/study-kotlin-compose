package org.poc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Switch
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var isDarkTheme by remember { mutableStateOf(false) }
    var selectedColor by remember { mutableStateOf(Color(0xFF6750A4)) }

    val colorScheme = when {
        isDarkTheme -> dynamicDarkColorScheme(selectedColor)
        else -> dynamicLightColorScheme(selectedColor)
    }

    MaterialTheme(
        colorScheme = colorScheme,
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Switch(
                    checked = isDarkTheme,
                    onCheckedChange = { isDarkTheme = it },
                    modifier = Modifier.padding(8.dp)
                )

                Text(
                    "Primary Colors",
                    style = MaterialTheme.typography.titleMedium
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ColorBox("Primary", MaterialTheme.colorScheme.primary)
                    ColorBox("On Primary", MaterialTheme.colorScheme.onPrimary)
                    ColorBox("Primary Container", MaterialTheme.colorScheme.primaryContainer)
                    ColorBox("On Primary Container", MaterialTheme.colorScheme.onPrimaryContainer)
                }
                
                Text(
                    "Secondary Colors",
                    style = MaterialTheme.typography.titleMedium
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ColorBox("Secondary", MaterialTheme.colorScheme.secondary)
                    ColorBox("On Secondary", MaterialTheme.colorScheme.onSecondary)
                    ColorBox("Secondary Container", MaterialTheme.colorScheme.secondaryContainer)
                    ColorBox("On Secondary Container", MaterialTheme.colorScheme.onSecondaryContainer)
                }
                
                Text(
                    "Tertiary Colors",
                    style = MaterialTheme.typography.titleMedium
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ColorBox("Tertiary", MaterialTheme.colorScheme.tertiary)
                    ColorBox("On Tertiary", MaterialTheme.colorScheme.onTertiary)
                    ColorBox("Tertiary Container", MaterialTheme.colorScheme.tertiaryContainer)
                    ColorBox("On Tertiary Container", MaterialTheme.colorScheme.onTertiaryContainer)
                }
            }
        }
    }
}

@Composable
fun ColorBox(name: String, color: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(color, RoundedCornerShape(8.dp))
        )
        Text(
            text = name,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}