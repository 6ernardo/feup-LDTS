package com.l14gr05.proj.controller;

import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.Main;

import java.io.IOException;

public abstract class Controller<T> {
    private T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Main main, LanternaGUI.ACTION action, long time) throws IOException;
}
