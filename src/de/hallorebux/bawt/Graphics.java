package de.hallorebux.bawt;

import java.awt.*;

/**
 * @author Nils Osswald
 */
public final class Graphics
{
    private final java.awt.Graphics graphics;
    private final int offX, offY, width, height;

    public Graphics(java.awt.Graphics graphics)
    {
        final Rectangle bounds = graphics.getClipBounds();

        this.graphics = graphics;
        this.offX = bounds.x;
        this.offY = bounds.y;
        this.width = bounds.width;
        this.height = bounds.height;
    }

    /**
     * Draws a filled rectangle
     * The left and the right edges of the rectangle are x and x + width.
     * The top and the bottom edges of the rectangle are y and y + height.
     *
     * @param x         the x position
     * @param y         the y position
     * @param width     the width
     * @param height    the height
     * @param color     the {@link Color}
     */
    public void drawRect(SizeReference x, SizeReference y, SizeReference width, SizeReference height, Color color)
    {
        graphics.setColor(color);
        graphics.drawRect(
                offX + x.get(this.width),
                offY + y.get(this.height),
                width.get(this.width),
                height.get(this.height)
        );
        graphics.fillRect(
                offX + x.get(this.width),
                offY + y.get(this.height),
                width.get(this.width),
                height.get(this.height)
        );
    }
}
