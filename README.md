# Compose animations codelab I

## Part I

First, we will create the button that we will use for the menu items, using a custom shape.

Using the `GenericShape` constructor, and applying basic trigonometry, we will obtain our [HexagonShape](app/src/main/java/dev/fabirt/composeanimationscodelab1/ui/theme/Shape.kt).

```kotlin
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
```

Then, create the composable for the button, using a `Box` to arrange content and the `clip` modifier with our `HexagonShape`. 
[Browse here.](app/src/main/java/dev/fabirt/composeanimationscodelab1/ui/component/HexagonalButton.kt)

```kotlin
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
```

### Result

<img
alt="Button result"
height="140"
src="docs/hexagonal_button_preview.png"
/>

### More

- [Compose animations cheat sheet](https://storage.googleapis.com/android-stories/compose/Compose_Animation_Cheat_Sheet.pdf)
- [Philipp Lackner Compose Animations YT tutorial](https://youtu.be/6ZZDPILtYlA)
