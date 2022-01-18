package de.hallorebux.bawt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
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

    public void addComponent(Component component)
    {
        components.add(component);
        component.setScreen(this);
    }

    public List<Component> allComponents()
    {
        return components;
    }

    public abstract void init();

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
