package com.l14gr05.proj.states;

import com.l14gr05.proj.controller.Controller;
import com.l14gr05.proj.controller.menu.LossMenuController;
import com.l14gr05.proj.model.menu.LossMenu;
import com.l14gr05.proj.viewer.Viewer;
import com.l14gr05.proj.viewer.menu.LossMenuViewer;

public class LossMenuState extends State<LossMenu>{
    public LossMenuState(LossMenu lossMenu){
        super(lossMenu);
    }

    @Override
    public Viewer<LossMenu> getViewer() {
        return new LossMenuViewer(getModel());
    }

    @Override
    public Controller<LossMenu> getController() {
        return new LossMenuController(getModel());
    }
}
