import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.menu.LossMenu;
import com.l14gr05.proj.viewer.menu.LossMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LossMenuViewerTest {

    public LossMenu lossmenu;

    public LossMenuViewer viewer;

    private GUI gui;

    @BeforeEach
    void setUp() {
        lossmenu = new LossMenu();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        gui.drawText(new Position(15,15), "You lost!", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(15,15), "You lost!", "#FFFFFF");
    }
}

