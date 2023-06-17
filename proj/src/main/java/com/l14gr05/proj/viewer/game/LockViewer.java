package com.l14gr05.proj.viewer.game;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.model.game.elements.Lock;

public class LockViewer implements ElementViewer<Lock>{
    @Override
    public void draw(Lock element, GUI gui) {
        gui.drawLock(element.getPosition());
    }
}
