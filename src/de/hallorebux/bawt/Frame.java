package de.hallorebux.bawt;

import com.sun.istack.internal.NotNull;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A Frame is equivalent to the <code>JFrame</code> in Java's AWT, 
 * or simply just the window. Since the <code>Frame</code> class extends 
 * of the <code>JFrame</code> class you are able to use all the functions 
 * that you know from the normal AWT including lots of useful 
 * extension functions provided by this class.
 *
 * @author Nils Osswald
 */
public final class Frame extends JFrame
{
    private boolean debugMode;
    private Screen currentScreen;

    /**
     * Creates a frame
     *
     * @param title         Determines the title on the window titlebar and the title of the task name
     * @param width         Determines the width of the window measured in pixels
     * @param height        Determines the height of the window measured in pixels
     * @param resizeable    Determines wheter the window <code>width</code> and <code>height</code> is adjustable
     * @param borderless    Determines if the window has the operating system default window style (equivalent to the <code>undecorated</code> option in AWT)
     */
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

    /**
     * Creates <code>resizeable</code>, <code>non-borderless</code>, 
     * <code>untitled</code> frame with a width of <code>800</code>
     * pixels and a height of <code>600</code> pixels. 
     */
    public Frame()
    {
        this("Untitled Frame", 800, 600, true, false);
    }
    
    /**
     * Creates <code>resizeable</code>, <code>non-borderless</code>
     * frame with a width of <code>800</code> pixels and 
     * a height of <code>600</code> pixels. 
     *
     * @param title Determines the title on the window titlebar and the title of the task name
     */
    public Frame(String title)
    {
        this(title, 800, 600, true, false);
    }

    /**
     * Creates <code>resizeable</code>, <code>non-borderless</code> frame 
     *
     * @param title     Determines the title on the window titlebar and the title of the task name
     * @param width     Determines the width of the window measured in pixels
     * @param height    Determines the height of the window measured in pixels
     */
    public Frame(String title, int width, int height)
    {
        this(title, width, height, true, false);
    }

    /**
     * Changes the current screen that is being managed and displayed
     *
     * @param screen the new screen to append (must not be <code>null</code>!)
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

    /**
     * @return wether the frame is <code>borderless</code> or not
     */
    public boolean isBorderless()
    {
        return this.isUndecorated();
    }

    /**
     * @return the current dislayed screen
     */
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
