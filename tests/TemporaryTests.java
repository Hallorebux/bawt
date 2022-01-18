import de.hallorebux.bawt.Component;
import de.hallorebux.bawt.Frame;
import de.hallorebux.bawt.RelativeSize;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public final class TemporaryTests
{
    @Test
    public void test()
    {
        Frame frame = new Frame();
        Component component = new SimpleComponent(
                new RelativeSize(.25F),
                new RelativeSize(.25F),
                new RelativeSize(.5F),
                new RelativeSize(.5F)
        );

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getCurrentScreen().addComponent(component);

        frame.setVisible(true);

        while (true);
    }
}
