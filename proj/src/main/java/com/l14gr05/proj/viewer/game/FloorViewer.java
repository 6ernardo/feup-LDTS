package com.l14gr05.proj.viewer.game;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.model.game.elements.Floor;

public class FloorViewer implements ElementViewer<Floor>{
    @Override
    public void draw(Floor element, GUI gui) {
        gui.drawFloor(element.getPosition(), element.getDurability(), element.isObjective());
    }
}
