package dev.fabirt.composeanimationscodelab1.ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class AnimatedMenuItem(
    val imageVector: ImageVector,
    val onClick: () -> Unit
)

val dummyMenuItems = listOf(
    AnimatedMenuItem(Icons.Rounded.Home) { },
    AnimatedMenuItem(Icons.Rounded.Notifications) { },
    AnimatedMenuItem(Icons.Rounded.Email) { },
    AnimatedMenuItem(Icons.Rounded.ShoppingCart) { },
    AnimatedMenuItem(Icons.Rounded.Call) { },
    AnimatedMenuItem(Icons.Rounded.Search) { },
)
