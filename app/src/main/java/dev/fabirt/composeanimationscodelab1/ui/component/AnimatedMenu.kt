package dev.fabirt.composeanimationscodelab1.ui.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.fabirt.composeanimationscodelab1.ui.model.AnimatedMenuItem
import dev.fabirt.composeanimationscodelab1.ui.model.dummyMenuItems
import dev.fabirt.composeanimationscodelab1.ui.theme.Alto
import dev.fabirt.composeanimationscodelab1.ui.theme.toRadians
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun AnimatedMenu(
    items: List<AnimatedMenuItem>,
    isCollapsed: Boolean,
    onChange: (Boolean) -> Unit
) {
    val currentState by animateFloatAsState(
        targetValue = if (isCollapsed) COLLAPSED_STATE else EXPANDED_STATE,
        animationSpec = tween(
            durationMillis = 400,
            easing = LinearEasing
        )
    )

    Box(
        modifier = Modifier
    ) {
        items.mapIndexed { index, item ->
            HexagonalButton(
                size = BUTTON_SIZE,
                onClick = item.onClick,
                color = Color.White,
                modifier = Modifier.absoluteOffset(
                    x = (currentState * (BUTTON_SIZE + 4) * cos((60f * index - 90).toRadians())).dp,
                    y = (currentState * (BUTTON_SIZE + 4) * sin((60f * index - 90).toRadians())).dp
                )
            ) {
                Icon(
                    imageVector = item.imageVector,
                    contentDescription = null,
                    tint = Alto,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        HexagonalButton(
            size = BUTTON_SIZE,
            onClick = {
                onChange(isCollapsed)
            }
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(currentState * 135f)
            )
        }
    }
}

private const val COLLAPSED_STATE = 0f
private const val EXPANDED_STATE = 1f
private const val BUTTON_SIZE = 80f

@Preview
@Composable
private fun AnimatedMenuPreview() {
    var isCollapsed by remember {
        mutableStateOf(true)
    }
    Box(
        modifier = Modifier.size(240.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedMenu(
            items = dummyMenuItems,
            isCollapsed = isCollapsed,
            onChange = {
                isCollapsed = !it
            }
        )
    }
}
