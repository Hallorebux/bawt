# Screen
[Screen Class](..\src\de\hallorebux\bawt\Screen.java)

Since the Frame is equivalent to `JFrame`, Screen is more or less the equivalent to `JPanel`, but it's only possible to render exactly **one** screen simultaneously.

## Constructors

*-*

## Functions

First let's have a look at all the functions that must be implemented due to its abstract keyword.

### abstract void init() {...}

#### Description:

This is the initialization function. It is called in `Frame#setScreen()` right before the previously displayed screen gets overwritten. Nevertheless you can use the `frame` attribute inside initialization process, because it was actually set before this function is called.

#### Parameters:

*-*

#### Return Type:

void

### abstract void exit() {...}

#### Description:

Called after the active screen is swapped or the frame closed.

#### Parameters:

*-*

#### Return Type:

void

## What's next?

Now that you have a frame and a screen setup, let's continue by adding an interactive component [here](components.md).