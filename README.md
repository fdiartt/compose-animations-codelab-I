# Compose animations codelab I

## Part III

Bearing in mind that whenever we want to use our animated menu we will have to create the corresponding state, 
we can create an state holder, in order to reduce code duplication and have a class that is responsible of abstracting the state.
[SwitchableState](app/src/main/java/dev/fabirt/composeanimationscodelab1/ui/state/SwitchableState.kt).

```kotlin
class SwitchableState(
    initialValue: Boolean = false,
) {

    var isOn by mutableStateOf(initialValue)
        private set

    fun toggle() {
        isOn = !isOn
    }
}
```

We can also create a handy function to remember this state.

```kotlin
@Composable
fun rememberSwitchableState(
    initialValue: Boolean = false,
): SwitchableState = remember {
    SwitchableState(initialValue)
}
```

Finally, we can refactor our menu preview to use the state holder.

```kotlin
private fun AnimatedMenuPreview() {
    val menuState = rememberSwitchableState(true)

    Box(
        modifier = Modifier.size(240.dp),
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
```

### More

- [Compose animations cheat sheet](https://storage.googleapis.com/android-stories/compose/Compose_Animation_Cheat_Sheet.pdf)
- [Philipp Lackner Compose Animations YT tutorial](https://youtu.be/6ZZDPILtYlA)
