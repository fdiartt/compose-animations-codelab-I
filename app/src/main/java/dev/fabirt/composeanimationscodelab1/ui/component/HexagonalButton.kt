package dev.fabirt.composeanimationscodelab1.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.fabirt.composeanimationscodelab1.ui.theme.AppTheme
import dev.fabirt.composeanimationscodelab1.ui.theme.HexagonShape
import dev.fabirt.composeanimationscodelab1.ui.theme.Orange

@Composable
fun HexagonalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = Orange,
    size: Float = DEFAULT_SIZE_DP,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .size(size.dp)
            .clip(HexagonShape)
            .background(color)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

private const val DEFAULT_SIZE_DP = 70f

@Composable
@Preview(name = "Hexagonal Button")
private fun HexagonalButtonPreview() {
    AppTheme {
        HexagonalButton(
            onClick = {  }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}
