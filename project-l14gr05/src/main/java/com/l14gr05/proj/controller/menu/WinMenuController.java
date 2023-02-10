package com.l14gr05.proj.controller.menu;

import com.l14gr05.proj.Main;
import com.l14gr05.proj.controller.Controller;
import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.arena.ArenaBuilder;
import com.l14gr05.proj.model.menu.WinMenu;
import com.l14gr05.proj.states.GameState;

import java.io.IOException;

public class WinMenuController extends Controller<WinMenu> {
    public WinMenuController(WinMenu winMenu){
        super(winMenu);
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) throws IOException {
        if(action==GUI.ACTION.UP){
            getModel().previousEntry();
        }
        else if(action==GUI.ACTION.DOWN){
            getModel().nextEntry();
        }
        else if(action==GUI.ACTION.SELECT){
            if(getModel().isSelectedExit()) main.setState(null);
            if(getModel().isSelectedPlayAgain()) main.setState(new GameState(new ArenaBuilder(1, 0).createArena()));
        }
        else if(action==GUI.ACTION.QUIT) main.setState(null);
    }
}
