import de.hallorebux.bawt.Frame;
import org.junit.jupiter.api.Test;

public final class TemporaryTests
{
    @Test
    public void test()
    {
        Frame frame = new Frame("Titled Frame", 400, 400, false, false);

        frame.setVisible(true);

        while (true);
    }
}
