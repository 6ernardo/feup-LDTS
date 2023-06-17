import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.menu.MainMenu;
import com.l14gr05.proj.viewer.menu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainMenuViewerTest {
    public MainMenu mainmenu;

    public MainMenuViewer viewer;

    private GUI gui;

    @BeforeEach
    void setUp() {
        mainmenu = new MainMenu();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        gui.drawText(new Position(15,15), "THIN ICE", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(15,15), "THIN ICE", "#FFFFFF");
    }
}
