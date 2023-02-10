package com.l14gr05.proj.controller.game;

import com.l14gr05.proj.Main;
import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.model.game.Position;
import com.l14gr05.proj.model.game.arena.Arena;

import java.io.IOException;

public class PuffleController extends GameController{
    public PuffleController(Arena arena){
        super(arena);
    }

    public void movePuffle(Position position){
        if(getModel().isStepable(position)){
            getModel().crackFloor(getModel().getPuffle().getPosition());
            getModel().setScore(getModel().getScore()+10);
            getModel().getPuffle().setPosition(position);
            getModel().pickKey();
            getModel().pickCoin();
        }
    }

    public void movePuffleLeft(){
        movePuffle(getModel().getPuffle().getPosition().getLeft());
    }

    public void movePuffleRight(){
        movePuffle(getModel().getPuffle().getPosition().getRight());
    }

    public void movePuffleUp(){
        movePuffle(getModel().getPuffle().getPosition().getUp());
    }

    public void movePuffleDown(){
        movePuffle(getModel().getPuffle().getPosition().getDown());
    }

    @Override
    public void step(Main main, GUI.ACTION action, long time) throws IOException {
        if(action == GUI.ACTION.UP) movePuffleUp();
        if(action == GUI.ACTION.DOWN) movePuffleDown();
        if(action == GUI.ACTION.RIGHT) movePuffleRight();
        if(action == GUI.ACTION.LEFT) movePuffleLeft();
    }
}
