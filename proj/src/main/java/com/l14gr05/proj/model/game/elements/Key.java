package com.l14gr05.proj.model.game.elements;

public class Key extends Element{
    private boolean collected;

    public Key(int x, int y){
        super(x,y);
        collected=false;
    }

    public void collectKey(){
        collected=true;
    }

    public boolean isCollected() {
        return collected;
    }
}
