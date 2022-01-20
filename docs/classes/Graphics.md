# Graphics
[Source](../..\src\de\hallorebux\bawt\Graphics.java)

A graphics utility resembling AWT's `Graphics` class but with `SizeReference`s instead of pixels
___
## Constructor(s)
```java
public Graphics(java.awt.Graphics graphics)
```
### Description
Initializes a `Graphics` clipped and translated on the given `graphics` clip bounds.
### Parameters
- *graphics*: the AWT `graphics` object of the parent `Screen`
___
## Functions
```java
public void drawRect(SizeReference x, SizeReference y, SizeReference width, SizeReference height, Color color)
```
### Description
Draws a filled rectangle; The left and the right edges of the rectangle are `x` and `x + width`. The top and the bottom edges of the rectangle are `y` and `y + height`.
### Parameters
- *x*:         the `x` position
- *y*:         the `y` position
- *width*:     the `width`
- *height*:    the `height`
- *color*:     the `color` to draw and fill the rectangle
___
> Author(s): Nils Osswald
