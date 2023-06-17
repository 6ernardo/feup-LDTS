package com.l14gr05.proj.viewer.game;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall>{
    @Override
    public void draw(Wall element, GUI gui) {
        gui.drawWall(element.getPosition());
    }
}
