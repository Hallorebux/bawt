import de.hallorebux.bawt.Frame;
import de.hallorebux.bawt.Screen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author Nils Osswald
 */
public final class FrameTests
{
    @Test
    public void titleTest()
    {
        String title = "Titled Frame";
        Frame frame = new Frame(title);

        Assertions.assertEquals(frame.getTitle(), title);
    }

    @Test
    public void sizeTest()
    {
        int width = 100, height = 60;
        Frame frame = new Frame("Custom Sized Frame", width, height);

        Assertions.assertEquals(frame.getWidth(), width);
        Assertions.assertEquals(frame.getHeight(), height);
    }

    @Test
    public void resizableTest()
    {
        boolean resizable = false;
        Frame frame = new Frame("Non Resizable Frame", 100, 60, resizable, false);

        Assertions.assertEquals(frame.isResizable(), resizable);
    }

    @Test
    public void borderlessTest()
    {
        boolean borderless = true;
        Frame frame = new Frame("Borderless Frame", 100, 60, true, true);

        Assertions.assertEquals(frame.isUndecorated(), borderless);
    }

    @Test
    public void defaultScreenTest()
    {
        Frame frame = new Frame();

        Assertions.assertEquals(frame.getCurrentScreen().getClass(), Screen.Empty.class);
    }
}
