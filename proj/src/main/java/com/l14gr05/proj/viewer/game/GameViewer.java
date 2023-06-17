package com.l14gr05.proj.viewer.game;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.game.elements.Element;
import com.l14gr05.proj.model.game.arena.Arena;
import com.l14gr05.proj.model.game.elements.Floor;
import com.l14gr05.proj.model.game.elements.Puffle;
import com.l14gr05.proj.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawElement(gui, getModel().getPuffle(), new PuffleViewer());
        drawElement(gui, getModel().getKey(), new KeyViewer());
        drawElement(gui, getModel().getLock(), new LockViewer());
        drawElement(gui, getModel().getCoin(), new CoinViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getFloors(), new FloorViewer());

        gui.drawText(new Position(0,1), "Score: " + getModel().getScore(), "#FFFFFF");
        gui.drawText(new Position(0,0), "Level: " + getModel().getLevel(), "#FFFFFF");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer){
        for( T element : elements){
            //se chao tiver mesma posicao que puffle, key ou coin apenas desenha o puffle, key ou coin
            if((getModel().getPuffle().getPosition().equals(element.getPosition()) ||
                    (getModel().getKey()!=null && getModel().getKey().getPosition().equals(element.getPosition()) && !getModel().getKey().isCollected()) ||
                    (getModel().getCoin()!=null && getModel().getCoin().getPosition().equals(element.getPosition()) && !getModel().getCoin().isCollected()))) continue;
            drawElement(gui, element, viewer);

        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        if(element!=null && (element.getClass() == Puffle.class || !getModel().getPuffle().getPosition().equals(element.getPosition()))) viewer.draw(element, gui);
    }
}
