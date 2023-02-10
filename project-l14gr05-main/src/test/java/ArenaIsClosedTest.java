import com.l14gr05.proj.controller.game.PuffleController;
import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.arena.Arena;
import com.l14gr05.proj.model.game.arena.ArenaBuilder;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.io.IOException;
import java.util.List;
public class ArenaIsClosedTest {
    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 1, max = 5) int level, @ForAll @IntRange(min = 3, max = 40) int score, @ForAll List<GUI.@From("moveActions") ACTION> actions) throws IOException {
        ArenaBuilder ab = new ArenaBuilder(level, score);
        Arena arena = ab.createArena();
        PuffleController controller = new PuffleController(arena);

        for (GUI.ACTION action : actions) {
            controller.step(null, action, 100);
            assert (controller.getModel().getPuffle().getPosition().getX() > 0);
            assert (controller.getModel().getPuffle().getPosition().getY() > 0);
            assert (controller.getModel().getPuffle().getPosition().getX() < arena.getWidth() - 1);
            assert (controller.getModel().getPuffle().getPosition().getY() < arena.getHeight() - 1);
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }
}

