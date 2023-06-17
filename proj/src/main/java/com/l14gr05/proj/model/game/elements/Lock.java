package com.l14gr05.proj.model.game.elements;

public class Lock extends Element{
    private boolean locked;

    public Lock(int x, int y){
        super(x,y);
        locked=true;
    }

    public void unlock(){
        locked=false;
    }
}
