package de.hallorebux.bawt;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * @author Nils Osswald
 */
public abstract class Component
{
    protected final SizeReference x, y, width, height;
    protected Screen screen;

    public Component(SizeReference x, SizeReference y, SizeReference width, SizeReference height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * @return If its bounding box contains the mouse cursor
     */
    protected boolean isHovered()
    {
        final Point point = screen.getMousePosition();

        return point.x >= x.get(screen.getWidth())
                && point.x >= x.get(screen.getWidth()) + width.get(screen.getWidth())
                && point.y >= y.get(screen.getHeight())
                && point.y <= y.get(screen.getHeight()) + height.get(screen.getHeight());
    }

    public abstract void paint(Graphics graphics);

    public abstract void mouseClicked(MouseEvent event);

    public abstract void keyTyped(KeyEvent event);

    public void setScreen(Screen screen)
    {
        this.screen = screen;
    }

    public Screen getScreen()
    {
        return screen;
    }
}
