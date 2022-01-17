package de.hallorebux.bawt;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nils Osswald
 */
public abstract class Screen extends JPanel
{
    protected Frame frame;
    protected final List<Component> components = new ArrayList<>();

    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
    }

    public void addComponent(Component component)
    {
        components.add(component);
        component.setScreen(this);
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
