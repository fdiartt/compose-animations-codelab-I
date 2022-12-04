package dev.fabirt.composeanimationscodelab1.ui.theme

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val HexagonShape = GenericShape { size, _ ->
    val radius = size.width / 2f
    val angle = 60f
    var xRef = 0f
    var yRef = size.width / 2f
    var sideCount = 0
    moveTo(xRef, yRef)

    while (sideCount < 5) {
        val theta = (angle - (angle * sideCount)).toRadians()
        val x = radius * cos(theta) + xRef
        val y = radius * sin(theta) + yRef

        lineTo(x, y)

        xRef = x
        yRef = y
        sideCount++
    }
    close()
}

fun Float.toRadians(): Float = (this * PI / 180f).toFloat()
