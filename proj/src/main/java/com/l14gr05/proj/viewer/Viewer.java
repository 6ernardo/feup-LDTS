package com.l14gr05.proj.viewer;

import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.gui.LanternaGUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private T model;

    public Viewer(T model){
        this.model=model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui);
}
