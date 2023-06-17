package com.l14gr05.proj.model.game.elements;

public class Puffle extends Element {

    private boolean key;

    public Puffle(int x, int y){
        super(x, y);
        key=false;
    }

    public boolean hasKey(){
        return key;
    }

    public void getKey(){
        key=true;
    }
}
