import de.hallorebux.bawt.Frame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Nils Osswald
 */
public final class ScreenTests
{
    @Test
    public void parentFrameTest()
    {
        Frame frame = new Frame();

        Assertions.assertEquals(frame.getCurrentScreen().getFrame(), frame);
    }
}
