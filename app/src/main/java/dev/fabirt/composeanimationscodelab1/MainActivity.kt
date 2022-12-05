package dev.fabirt.composeanimationscodelab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.fabirt.composeanimationscodelab1.ui.component.AnimatedMenu
import dev.fabirt.composeanimationscodelab1.ui.model.dummyMenuItems
import dev.fabirt.composeanimationscodelab1.ui.state.rememberSwitchableState
import dev.fabirt.composeanimationscodelab1.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Compose Animations I") }
                )
            },
            backgroundColor = Color(0xFF333333),
        ) {
            val menuState = rememberSwitchableState(true)

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                AnimatedMenu(
                    items = dummyMenuItems,
                    isCollapsed = menuState.isOn,
                    onChange = {
                        menuState.toggle()
                    }
                )
            }
        }
    }
}
