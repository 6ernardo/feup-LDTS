import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.elements.Puffle;
import com.l14gr05.proj.viewer.game.PuffleViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PuffleViewerTest{

    private Puffle puffle;

    private PuffleViewer viewer;

    private GUI gui;

    @BeforeEach
    void setUp() {
        puffle = new Puffle(20, 20);
        viewer = new PuffleViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(puffle, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPuffle(puffle.getPosition());
    }

}
