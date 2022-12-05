# Compose animations codelab I

## Part II

Here we will create our stack of buttons and the corresponding animations.

First, define a data class to hold menu items data. Define a list of dummy items to fill the menu. [AnimatedMenuItem](app/src/main/java/dev/fabirt/composeanimationscodelab1/ui/model/AnimatedMenuItem.kt).

Now, we will stack 7 buttons, using `Box`, 6 from the list and 1 to toogle the state, which will be always visible.

The state controller will be a float, which will go from 0 (collapsed state) to 1 (expanded state). To control the menu state,
the composable will receive a boolean parameter.

Mapping the items list, we can assing a different angle for each button. Using `absoluteOffset` modifier, we can transform
the position of each button.

Finally, the toggle icon will rotate from 0 to 135 degrees. [AnimatedMenu](app/src/main/java/dev/fabirt/composeanimationscodelab1/ui/component/AnimatedMenu.kt)

### Result

<img
alt="Animated menu preview"
height="240"
src="docs/animated_menu.gif"
/>

### More

- [Compose animations cheat sheet](https://storage.googleapis.com/android-stories/compose/Compose_Animation_Cheat_Sheet.pdf)
- [Philipp Lackner Compose Animations YT tutorial](https://youtu.be/6ZZDPILtYlA)
