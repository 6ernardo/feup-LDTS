package com.l14gr05.proj.model.game.elements;

public class Coin extends Element{
    private boolean collected=false;

    public Coin(int x, int y){
        super(x,y);
    }

    public void collectCoin(){
        collected=true;
    }

    public boolean isCollected(){
        return collected;
    }
}
