package org.poc.ui.components

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Example : Screen("example")
    object ComposeGuide : Screen("compose-guide")
    object LayoutResponsive : Screen("layout-responsive")
    object SideEffects : Screen("side-effects")
} 