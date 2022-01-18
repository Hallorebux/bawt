package de.hallorebux.bawt;

import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Nils Osswald
 */
public final class Frame extends JFrame
{
    private boolean debugMode;

    private Screen currentScreen;

    public Frame(String title, int width, int height, boolean resizable, boolean borderless)
    {
        this.setTitle(title);
        this.setSize(width, height);
        this.setResizable(resizable);
        this.setUndecorated(borderless);
        // center frame on screen
        this.setLocationRelativeTo(null);

        setScreen(new Screen.Empty());

        this.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                currentScreen.allComponents().forEach(c -> c.keyTyped(e));
            }
        });

        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                currentScreen.exit();
            }
        });
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

    /**
     * Changes the current {@link Screen}
     *
     * @param screen the new {@link Screen}
     */
    public void setScreen(@NotNull Screen screen)
    {
        if (currentScreen != null)
            currentScreen.exit();

        screen.setFrame(this);
        screen.init();
        currentScreen = screen;

        this.setContentPane(screen);

        this.repaint();
        this.revalidate();
    }

    public boolean isBorderless()
    {
        return this.isUndecorated();
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
