package com.l14gr05.proj.controller.game;

import com.l14gr05.proj.Main;
import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.arena.Arena;
import com.l14gr05.proj.model.game.arena.ArenaBuilder;
import com.l14gr05.proj.model.menu.LossMenu;
import com.l14gr05.proj.model.menu.MainMenu;
import com.l14gr05.proj.model.menu.WinMenu;
import com.l14gr05.proj.states.GameState;
import com.l14gr05.proj.states.LossMenuState;
import com.l14gr05.proj.states.MainMenuState;
import com.l14gr05.proj.states.WinMenuState;

import java.io.IOException;

public class ArenaController extends GameController{
    private PuffleController puffleController;

    public ArenaController(Arena arena){
        super(arena);

        this.puffleController= new PuffleController(arena);
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) throws IOException {
        if(getModel().reachObjective()){
            if(getModel().getLevel()<12){
                main.setState(new GameState(new ArenaBuilder(getModel().getLevel()+1, getModel().getScore()).createArena()));
            }
            else main.setState(new WinMenuState(new WinMenu(getModel().getScore())));
        }
        else if(action == GUI.ACTION.QUIT) main.setState(new MainMenuState(new MainMenu()));
        else if(!getModel().canMove(getModel().getPuffle().getPosition())) main.setState(new LossMenuState(new LossMenu()));
        else{
            puffleController.step(main, action, time);
        }
    }
}
