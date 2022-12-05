package dev.fabirt.composeanimationscodelab1.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun rememberSwitchableState(
    initialValue: Boolean = false,
): SwitchableState = remember {
    SwitchableState(initialValue)
}

class SwitchableState(
    initialValue: Boolean = false,
) {

    var isOn by mutableStateOf(initialValue)
        private set

    fun toggle() {
        isOn = !isOn
    }
}
