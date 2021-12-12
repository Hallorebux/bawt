import de.hallorebux.bawt.Frame;
import org.junit.jupiter.api.Test;

/**
 * @author Nils Osswald
 * @author Noah Gerber
 */
public class FrameTests
{
    @Test
    public void titleTest()
    {
        Frame frame = new Frame("Basic Frame");
        frame.setVisible(true);

        while (true) { }
    }
}
