package de.hallorebux.bawt;

import java.awt.*;

/**
 * A graphics utility resembling AWT's <code>Graphics</code> class but 
 * with <code>SizeReference</code>s instead of pixels
 *
 * @author Nils Osswald
 */
public final class Graphics
{
    private final java.awt.Graphics graphics;
    private final int offX, offY, width, height;

    /**
     * Initializes a <code>Graphics</code> clipped and translated on the
     * given <code>graphics</code> clip bounds.
     * 
     * @param graphics the AWT <code>graphics</code> object of the parent <code>Screen</code>
     */
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
     * Draws a filled rectangle;
     * The left and the right edges of the rectangle are <code>x</code> and <code>x + width</code>.
     * The top and the bottom edges of the rectangle are <code>y</code> and <code>y + height</code>.
     *
     * @param x         the <code>x</code> position
     * @param y         the <code>y</code> position
     * @param width     the <code>width</code>
     * @param height    the <code>height</code>
     * @param color     the <code>color</code> to draw and fill the rectangle
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
