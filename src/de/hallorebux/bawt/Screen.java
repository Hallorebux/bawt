package de.hallorebux.bawt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Since the Frame is equivalent to <code>JFrame</code>, Screen is more 
 * or less the equivalent to <code>JPanel</code>, but it's only possible 
 * to render exactly one screen simultaneously.
 *
 * @author Nils Osswald
 */
public abstract class Screen extends JPanel
{
    protected Frame frame;
    protected final List<Component> components = new ArrayList<>();

    public Screen()
    {
        this.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                components.forEach(c -> c.mouseClicked(e));
            }
        });
    }

    @Override
    public void paint(java.awt.Graphics g)
    {
        super.paint(g);

        final Graphics graphics = new Graphics(g);

        this.setBackground(new Color(25, 25, 25));

        components.forEach(c -> c.paint(graphics));

        repaint();
    }

    /**
     * Addds a new component to the <code>Screen</code>
     *
     * @param component the component to add
     */
    public void addComponent(Component component)
    {
        components.add(component);
        component.setScreen(this);
    }

    /**
     * @return a <code>List</code> of all <code>Component</code>s on this <code>Screen</code> 
     */
    public List<Component> allComponents()
    {
        return components;
    }

    /**
     * This is the initialization function. 
     * It is called in <code>Frame.setScreen()</code> right before 
     * the previously displayed screen gets overwritten. 
     * Nevertheless you can use the <code>frame</code> attribute 
     * inside the initialization process, because it was 
     * actually set before this function is called.
     */
    public abstract void init();

    /**
     * Called after the active screen is swapped or the frame closed
     */
    public abstract void exit();

    public static final class Empty extends Screen
    {
        @Override
        public void init() { }

        @Override
        public void exit() { }
    }

    public void setFrame(Frame frame)
    {
        this.frame = frame;
    }

    public Frame getFrame()
    {
        return frame;
    }
}
