package org.poc

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.ui.unit.dp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "study",
        state = rememberWindowState(width = 1920.dp, height = 1080.dp)
    ) {
        App()
    }
}