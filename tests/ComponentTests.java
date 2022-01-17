import de.hallorebux.bawt.AbsoluteSize;
import de.hallorebux.bawt.Component;
import de.hallorebux.bawt.Frame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Nils Osswald
 */
public final class ComponentTests
{
    @Test
    public void parentScreenTest()
    {
        Frame frame = new Frame();
        Component component = new SimpleComponent(new AbsoluteSize(0),
                new AbsoluteSize(0), new AbsoluteSize(0), new AbsoluteSize(0));

        frame.getCurrentScreen().addComponent(component);

        Assertions.assertEquals(component.getScreen(), frame.getCurrentScreen());
    }
}
