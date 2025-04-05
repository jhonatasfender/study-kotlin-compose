package org.poc.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.poc.ui.components.Sidebar
import org.poc.ui.components.Screen
import androidx.compose.ui.Alignment

@Composable
@Preview
fun Home() {
    var currentRoute by remember { mutableStateOf(Screen.Home.route) }
    
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxSize()) {
            Sidebar(
                currentRoute = currentRoute,
                onNavigate = { route -> currentRoute = route }
            )
            
            Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
                when (currentRoute) {
                    Screen.Home.route -> Text("Home Page")
                    Screen.Example.route -> ExamplePage()
                    Screen.ComposeGuide.route -> ComposeGuidePage()
                    Screen.LayoutResponsive.route -> LayoutResponsivePage()
                    Screen.SideEffects.route -> SideEffectsPage()
                }
            }
        }
    }
}