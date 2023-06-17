import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.elements.Coin;
import com.l14gr05.proj.viewer.game.CoinViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CoinViewerTest {
    private Coin coin;

    private CoinViewer viewer;

    private GUI gui;

    @BeforeEach
    void setUp() {
        coin = new Coin(20, 20);
        viewer = new CoinViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(coin, gui);
        Mockito.verify(gui, Mockito.times(1)).drawCoin(coin.getPosition());
    }
}
