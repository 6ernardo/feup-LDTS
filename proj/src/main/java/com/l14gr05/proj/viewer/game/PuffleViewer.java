package com.l14gr05.proj.viewer.game;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.model.game.elements.Puffle;

public class PuffleViewer implements ElementViewer<Puffle>{
    @Override
    public void draw(Puffle element, GUI gui) {
        gui.drawPuffle(element.getPosition());
    }
}
