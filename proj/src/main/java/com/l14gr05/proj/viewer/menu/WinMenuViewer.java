package com.l14gr05.proj.viewer.menu;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.menu.WinMenu;
import com.l14gr05.proj.viewer.Viewer;

public class WinMenuViewer extends Viewer<WinMenu> {
    public WinMenuViewer(WinMenu winMenu){
        super(winMenu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(15,15), "You won!", "#FFFFFF");
        gui.drawText(new Position(15,16), "Score: " + getModel().getFinalscore(), "#FFFFFF");

        for(int i=0; i<getModel().getNumberEntries(); i++){
            gui.drawText(new Position(15,18+i), getModel().getEntry(i), getModel().isSelected(i) ?  "#FFD700" : "#FFFFFF");
        }
    }
}
