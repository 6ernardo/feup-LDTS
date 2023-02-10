package com.l14gr05.proj.viewer.game;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin>{
    @Override
    public void draw(Coin element, GUI gui) {
        gui.drawCoin(element.getPosition());
    }
}
