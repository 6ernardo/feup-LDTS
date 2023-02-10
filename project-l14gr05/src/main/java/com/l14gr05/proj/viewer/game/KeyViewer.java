package com.l14gr05.proj.viewer.game;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.model.game.elements.Key;

public class KeyViewer implements ElementViewer<Key> {
    @Override
    public void draw(Key element, GUI gui) {
        gui.drawKey(element.getPosition());
    }
}
