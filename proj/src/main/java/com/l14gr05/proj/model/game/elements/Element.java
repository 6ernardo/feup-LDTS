package com.l14gr05.proj.model.game.elements;

import com.l14gr05.proj.model.game.Position;

public abstract class Element {
    private Position position;

    public Element(int x, int y){
        this.position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
