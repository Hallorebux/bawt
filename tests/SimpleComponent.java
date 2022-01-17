import de.hallorebux.bawt.Component;
import de.hallorebux.bawt.SizeReference;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * @author Nils Osswald
 */
public final class SimpleComponent extends Component
{
    public SimpleComponent(SizeReference x, SizeReference y, SizeReference width, SizeReference height)
    {
        super(x, y, width, height);
    }

    @Override
    public void paint(Graphics graphics) { }

    @Override
    public void mouseClicked(MouseEvent event) { }

    @Override
    public void keyTyped(KeyEvent event) { }
}
