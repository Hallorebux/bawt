# Screen
[Source](../..\src\de\hallorebux\bawt\Screen.java)

Since the Frame is equivalent to `JFrame`, Screen is more or less the equivalent to `JPanel`, but it's only possible to render exactly one screen simultaneously.
___
## Functions
```java
public void addComponent(Component component)
```
### Description
Addds a new component to the `Screen`
### Parameters
- *component*: the component to add
```java
public List<Component> allComponents()
```
### Description
Returns a `List` of all `Component`s on this `Screen`
```java
public abstract void init();
```
### Description
This is the initialization function. It is called in `Frame.setScreen()` right before the previously displayed screen gets overwritten. Nevertheless you can use the `frame` attribute inside the initialization process, because it was actually set before this function is called.
```java
public abstract void exit();
```
### Description
Called after the active screen is swapped or the frame closed
___
> Author(s): Nils Osswald
