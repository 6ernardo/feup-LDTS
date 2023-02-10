package com.l14gr05.proj.states;

import com.l14gr05.proj.controller.Controller;
import com.l14gr05.proj.controller.menu.MainMenuController;
import com.l14gr05.proj.model.menu.MainMenu;
import com.l14gr05.proj.viewer.Viewer;
import com.l14gr05.proj.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<MainMenu>{
    public MainMenuState(MainMenu mainMenu){
        super(mainMenu);
    }

    @Override
    public Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    public Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
