package com.l14gr05.proj.viewer.menu;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.menu.LossMenu;
import com.l14gr05.proj.viewer.Viewer;

public class LossMenuViewer extends Viewer<LossMenu> {
    public LossMenuViewer(LossMenu lossMenu) {
        super(lossMenu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(15,15), "You lost!", "#FFFFFF");

        for(int i=0; i<getModel().getNumberEntries(); i++){
            gui.drawText(new Position(15,17+i), getModel().getEntry(i), getModel().isSelected(i) ?  "#FFD700" : "#FFFFFF");
        }
    }
}
