# Component
[Source](../..\src\de\hallorebux\bawt\Component.java)

A `Component` can either be a single component or multiple components put together.
___
## Constructor(s)
```java
public Component(SizeReference x, SizeReference y, SizeReference width, SizeReference height)
```
### Description
Creates a `Component` object with its location based on the given parameters
### Parameters
- *x*:         the `x` position
- *y*:         the `y` position
- *width*:     the `width`
- *height*:    the `height`
___
## Functions
```java
protected boolean isHovered()
```
### Description
Returns if its bounding box contains the mouse cursor
```java
public abstract void paint(Graphics graphics);
```
### Description
Paints the `Component`
### Parameters
- *graphics*: the `graphics` object provided by BAWT
```java
public abstract void mouseClicked(MouseEvent event);
```
### Description
Called if a mouse button is clicked
### Parameters
- *event*: the `MouseEvent`
```java
public abstract void keyTyped(KeyEvent event);
```
### Description
Called if a key was typed
### Parameters
- *event*: the `KeyEvent`
```java
public Screen getScreen()
```
### Description
Returns the parent `Screen`
___
> Author(s): Nils Osswald
