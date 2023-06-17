import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.game.arena.Arena;
import com.l14gr05.proj.model.game.elements.Puffle;
import com.l14gr05.proj.model.game.elements.Floor;
import com.l14gr05.proj.model.game.elements.Wall;
import com.l14gr05.proj.model.game.arena.ArenaBuilder;
import com.l14gr05.proj.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;

class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;


    @BeforeEach
    void setUp() {
        arena = new Arena(40, 40, 0, 0);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setWalls(Arrays.asList(new Wall(10, 21), new Wall(11, 21), new Wall(12, 21)));
        arena.setFloors(Arrays.asList(new Floor(11, 20, 1, false), new Floor(12, 20, 2, true)));
        arena.setPuffle(new Puffle(20, 20));
    }

    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(10, 21));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(11, 21));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(12, 21));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawFloor() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawFloor(new Position(11, 20),1, false);
        Mockito.verify(gui, Mockito.times(1)).drawFloor(new Position(12, 20), 2, true);
        //Mockito.verify(gui, Mockito.times(2)).drawFloor(Mockito.any(Position.class), Mockito.any(int), Mockito.any(boolean));
    }

    @Test
    void drawPuffle() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPuffle(new Position(20, 20));
        Mockito.verify(gui, Mockito.times(1)).drawPuffle(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}