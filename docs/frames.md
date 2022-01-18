# Frame 
[Frame Class](..\src\de\hallorebux\bawt\Frame.java)

A Frame is equivalent to the `JFrame` in Java's AWT, or simply just the window. Since the `Frame` class extends of the `JFrame` class you are able to use all the functions that you know from the normal AWT including lots of useful extension functions by BAWT.

## Constructors

The `Frame` class consits of multiple constructors. Each constructor calls the default constructor which  looks like this:

```java
public Frame(String title, int width, int height, boolean resizable, boolean borderless) {...}
```

- *title*: Determines the title on the window titlebar and the title of the windows task name
- *width*: Determines the width of the window measured in pixels
- *height*: Determines the height of the window measured in pixels
- *resizeable*: Determines wheter the windows width and height is adjustable
- *borderless*: Determines if the window has the operating systems default window style (equivalent to the *undecorated* option in AWT)

The simplified constructors use default values for each of the parameters:
- *title*: `"Untitled Frame"`
- *width*: `800`
- *height*: `600`
- *resizable*: `true`
- *borderless*: `false`

Once the constructor gets called, the window is initialized with an empty screen, and bound to the center of the currently active screen using
```java
setLocationRelativeTo(null);
```
If you want your window to not be centered you can change that after calling its constructor.

## Functions

As already mentioned the Frame class comes with the default AWT funtctions, aswell lots of new functions. The most important new functions are listed below:

### void setScreen(@NotNull Screen screen)

#### Description:

This function is used to change the active screen that is being managed and rendered by the Frame.

#### Parameters:

- *screen*: The screen to change to (must not be `null`)

#### Return Type:

void

## What's next?

Continue by adding a custom `Screen` to your frame. Continue reading [here](screens.md).