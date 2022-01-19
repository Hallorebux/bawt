# Frame
[Source](../..\src\de\hallorebux\bawt\Frame.java)

A Frame is equivalent to the `JFrame` in Java's AWT, or simply just the window. Since the `Frame` class extends of the `JFrame` class you are able to use all the functions that you know from the normal AWT including lots of useful extension functions provided by this class.
___
## Constructor(s)
```java
public Frame(String title, int width, int height, boolean resizable, boolean borderless)
```
### Description
Creates a frame
### Parameters
- *title*:         Determines the title on the window titlebar and the title of the task name
- *width*:         Determines the width of the window measured in pixels
- *height*:        Determines the height of the window measured in pixels
- *resizeable*:    Determines wheter the window `width` and `height` is adjustable
- *borderless*:    Determines if the window has the operating system default window style (equivalent to the `undecorated` option in AWT)
```java
public Frame()
```
### Description
Creates `resizeable`, `non-borderless`, `untitled` frame with a width of `800` pixels and a height of `600` pixels.
```java
public Frame(String title)
```
### Description
Creates `resizeable`, `non-borderless` frame with a width of `800` pixels and a height of `600` pixels.
### Parameters
- *title*: Determines the title on the window titlebar and the title of the task name
```java
public Frame(String title, int width, int height)
```
### Description
Creates `resizeable`, `non-borderless` frame
### Parameters
- *title*:     Determines the title on the window titlebar and the title of the task name
- *width*:     Determines the width of the window measured in pixels
- *height*:    Determines the height of the window measured in pixels
___
## Functions
```java
public void setScreen(@NotNull Screen screen)
```
### Description
Changes the current screen that is being managed and displayed
### Parameters
- *screen*: the new screen to append (must not be `null`!)
```java
public boolean isBorderless()
```
### Description
Returns wether the frame is `borderless` or not
```java
public Screen getCurrentScreen()
```
### Description
Returns the current dislayed screen
___
> Author(s): Nils Osswald
