import com.l14gr05.proj.controller.game.PuffleController;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.game.arena.Arena;
import com.l14gr05.proj.model.game.elements.Puffle;
import com.l14gr05.proj.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuffleControllerTest {
    private PuffleController controller;
    private Puffle puffle;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10,1,0);

        puffle = new Puffle(5, 5);
        arena.setPuffle(puffle);

        arena.setWalls(Arrays.asList());
        arena.setFloors(Arrays.asList());

        controller = new PuffleController(arena);
    }

    @Test
    void moveHeroRightEmpty() {
        controller.movePuffleRight();
        assertEquals(new Position(6, 5), puffle.getPosition());
    }

    @Test
    void moveHeroRightNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.movePuffleRight();
        assertEquals(new Position(5, 5), puffle.getPosition());
    }

    @Test
    void moveHeroLeftEmpty() {
        controller.movePuffleLeft();
        assertEquals(new Position(4, 5), puffle.getPosition());

    }

    @Test
    void moveHeroLeftNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(4,5 )));
        controller.movePuffleLeft();
        assertEquals(new Position(5, 5), puffle.getPosition());

    }

    @Test
    void moveHeroUpEmpty(){
        controller.movePuffleUp();
        assertEquals(new Position(5, 4), puffle.getPosition());
    }

    @Test
    void moveHeroUpNotEmpty(){
        arena.setWalls(Arrays.asList(new Wall(5,4 )));
        controller.movePuffleUp();
        assertEquals(new Position(5, 5), puffle.getPosition());
    }

    @Test
    void moveHeroDownEmpty(){
        controller.movePuffleDown();
        assertEquals(new Position(5, 6), puffle.getPosition());
    }

    @Test
    void moveHeroDownNotEmpty(){
        arena.setWalls(Arrays.asList(new Wall(5,6 )));
        controller.movePuffleDown();
        assertEquals(new Position(5, 5), puffle.getPosition());
    }
}
