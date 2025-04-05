package org.poc

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.poc.ui.theme.AppTheme
import org.poc.ui.pages.Home

@Composable
@Preview
fun App() {
    AppTheme {
        Home()
    }
}