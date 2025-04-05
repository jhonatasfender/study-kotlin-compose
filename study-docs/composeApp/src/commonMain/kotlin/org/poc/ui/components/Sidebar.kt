package org.poc.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.poc.ui.pages.Home
import org.poc.ui.pages.ExamplePage
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.ViewModule
import androidx.compose.material.icons.filled.Science
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState

@Composable
fun Sidebar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "Navigation",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NavigationItem(
                selected = currentRoute == Screen.Home.route,
                onClick = { onNavigate(Screen.Home.route) },
                icon = Icons.Default.Home,
                label = "Home"
            )
            
            NavigationItem(
                selected = currentRoute == Screen.Example.route,
                onClick = { onNavigate(Screen.Example.route) },
                icon = Icons.Default.Star,
                label = "Example"
            )
            
            NavigationItem(
                selected = currentRoute == Screen.ComposeGuide.route,
                onClick = { onNavigate(Screen.ComposeGuide.route) },
                icon = Icons.Default.Code,
                label = "Como trabalhar com o Compose"
            )

            NavigationItem(
                selected = currentRoute == Screen.LayoutResponsive.route,
                onClick = { onNavigate(Screen.LayoutResponsive.route) },
                icon = Icons.Default.ViewModule,
                label = "Layout Responsivo"
            )

            NavigationItem(
                selected = currentRoute == Screen.SideEffects.route,
                onClick = { onNavigate(Screen.SideEffects.route) },
                icon = Icons.Default.Science,
                label = "Side Effects"
            )
        }
    }
}

@Composable
private fun NavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    label: String
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .background(
                when {
                    selected -> MaterialTheme.colorScheme.primaryContainer
                    isHovered -> MaterialTheme.colorScheme.surfaceVariant
                    else -> Color.Transparent
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) MaterialTheme.colorScheme.onPrimaryContainer
                   else MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = if (selected) MaterialTheme.colorScheme.onPrimaryContainer
                   else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
} 