package de.hallorebux.bawt;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * A <code>Component</code> can either be a single component or multiple components put together.
 *
 * @author Nils Osswald
 */
public abstract class Component
{
    protected final SizeReference x, y, width, height;
    protected Screen screen;

    /**
     * Creates a <code>Component</code> object with its location 
     * based on the given parameters
     *
     * @param x         the <code>x</code> position
     * @param y         the <code>y</code> position
     * @param width     the <code>width</code>
     * @param height    the <code>height</code>
     */
    public Component(SizeReference x, SizeReference y, SizeReference width, SizeReference height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * @return if its bounding box contains the mouse cursor
     */
    protected boolean isHovered()
    {
        final Point point = screen.getMousePosition();

        return point.x >= x.get(screen.getWidth())
                && point.x >= x.get(screen.getWidth()) + width.get(screen.getWidth())
                && point.y >= y.get(screen.getHeight())
                && point.y <= y.get(screen.getHeight()) + height.get(screen.getHeight());
    }

    /**
     * Paints the <code>Component</code>
     *
     * @param graphics the <code>graphics</code> object provided by BAWT
     */
    public abstract void paint(Graphics graphics);

    /**
     * Called if a mouse button is clicked
     *
     * @param event the <code>MouseEvent</code>
     */
    public abstract void mouseClicked(MouseEvent event);

    /**
     * Called if a key was typed
     *
     * @param event the <code>KeyEvent</code>
     */
    public abstract void keyTyped(KeyEvent event);

    public void setScreen(Screen screen)
    {
        this.screen = screen;
    }

    /**
     * @return the parent <code>Screen</code>
     */
    public Screen getScreen()
    {
        return screen;
    }
}
