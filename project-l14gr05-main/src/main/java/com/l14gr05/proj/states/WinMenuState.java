package com.l14gr05.proj.states;

import com.l14gr05.proj.controller.Controller;
import com.l14gr05.proj.controller.menu.WinMenuController;
import com.l14gr05.proj.model.menu.WinMenu;
import com.l14gr05.proj.viewer.Viewer;
import com.l14gr05.proj.viewer.menu.WinMenuViewer;

public class WinMenuState extends State<WinMenu>{
    public WinMenuState(WinMenu winMenu){
        super(winMenu);
    }

    @Override
    public Viewer<WinMenu> getViewer() {
        return new WinMenuViewer(getModel());
    }

    @Override
    public Controller<WinMenu> getController() {
        return new WinMenuController(getModel());
    }
}
