package com.l14gr05.proj.model.game.elements;

import com.l14gr05.proj.model.game.Position;

public class Floor extends Element {
    private int durability;
    private boolean objective;
    private Position position;

    public Floor(int x, int y, int durability, boolean objective){
        super(x,y);
        this.durability=durability;
        this.objective=objective;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isObjective() {
        return objective;
    }

}
