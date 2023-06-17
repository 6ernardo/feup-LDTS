import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.elements.Lock;
import com.l14gr05.proj.viewer.game.LockViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LockViewerTest {
    private Lock lock;

    private LockViewer viewer;

    private GUI gui;

    @BeforeEach
    void setUp() {
        lock = new Lock(10, 10);
        viewer = new LockViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(lock, gui);
        Mockito.verify(gui, Mockito.times(1)).drawLock(lock.getPosition());
    }
}
