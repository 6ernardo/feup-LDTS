package com.l14gr05.proj.viewer.menu;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.viewer.Viewer;
import com.l14gr05.proj.model.menu.MainMenu;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu mainMenu){
        super(mainMenu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(15,15), "THIN ICE", "#FFFFFF");

        for(int i=0; i<getModel().getNumberEntries(); i++){
            gui.drawText(new Position(15,17+i), getModel().getEntry(i), getModel().isSelected(i) ?  "#FFD700" : "#FFFFFF");
        }
    }
}
