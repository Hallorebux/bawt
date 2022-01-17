package de.hallorebux.bawt;

import javax.swing.*;

/**
 * @author Nils Osswald
 */
public final class Frame extends JFrame
{
    private Screen currentScreen;
    private boolean debugMode;

    public Frame(String title, int width, int height, boolean resizable, boolean borderless)
    {
        this.setTitle(title);
        this.setSize(width, height);
        this.setResizable(resizable);
        this.setUndecorated(borderless);

        // set default screen
        setScreen(new Screen.Empty());
    }

    public Frame()
    {
        this("Untitled Frame", 800, 600, true, false);
    }

    public Frame(String title)
    {
        this(title, 800, 600, true, false);
    }

    public Frame(String title, int width, int height)
    {
        this(title, width, height, true, false);
    }

    public void setScreen(Screen screen)
    {
        if (currentScreen != null)
            currentScreen.exit();

        currentScreen = screen;
        currentScreen.setFrame(this);
        currentScreen.init();
    }

    public Screen getCurrentScreen()
    {
        return currentScreen;
    }

    public void setDebugMode(boolean debugMode)
    {
        this.debugMode = debugMode;
    }

    public boolean isDebugMode()
    {
        return debugMode;
    }
}
