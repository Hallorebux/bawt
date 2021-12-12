package de.hallorebux.bawt;

import javax.swing.*;

/**
 * @author Nils Osswald
 * @author Noah Gerber
 */
public final class Frame extends JFrame
{
    private Screen currentScreen;

    public Frame(String title)
    {
        this.setTitle(title);
    }

    public Screen getCurrentScreen()
    {
        return currentScreen;
    }
}
