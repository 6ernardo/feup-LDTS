import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall extends Element {

    public Wall(int x, int y) {
        super(x, y);
    }

    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "#");
    }
}
