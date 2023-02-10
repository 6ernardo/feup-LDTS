package com.l14gr05.proj.gui;

import com.l14gr05.proj.model.game.Position;

import java.io.IOException;

public interface GUI {
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT};

    ACTION getNextAction() throws IOException;

    public void drawPuffle(Position position);

    public void drawWall(Position position);

    public void drawFloor(Position position, int durability, boolean objective);

    public void drawCoin(Position position);

    public void drawKey(Position position);

    public void drawLock(Position position);

    public void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}
