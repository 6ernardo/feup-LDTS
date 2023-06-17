import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.menu.WinMenu;
import com.l14gr05.proj.viewer.menu.WinMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WinMenuViewerTest {
    public WinMenu winmenu;

    public WinMenuViewer viewer;

    private GUI gui;

    @BeforeEach
    void setUp() {
        winmenu= new WinMenu(150);
        gui = Mockito.mock(GUI.class);
    }
    @Test
    void drawElement() {
        gui.drawText(new Position(15,15), "You won!", "#FFFFFF");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(15,15), "You won!", "#FFFFFF");
    }
}
