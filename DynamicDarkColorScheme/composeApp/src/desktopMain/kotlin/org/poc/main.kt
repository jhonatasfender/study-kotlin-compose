package org.poc

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Dynamic Color Scheme Demo",
    ) {
        App()
    }
}