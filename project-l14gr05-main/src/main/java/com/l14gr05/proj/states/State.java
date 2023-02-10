package com.l14gr05.proj.states;

import com.l14gr05.proj.Main;
import com.l14gr05.proj.controller.Controller;
import com.l14gr05.proj.gui.GUI;
import com.l14gr05.proj.viewer.Viewer;

import javax.imageio.IIOException;
import java.io.IOException;

public abstract class State<T> {
    private T model;
    private Controller<T> controller;
    private Viewer<T> viewer;

    public State(T model){
        this.model=model;
        this.viewer=getViewer();
        this.controller=getController();
    }

    public abstract Viewer<T> getViewer();

    public abstract Controller<T> getController();

    public T getModel(){
        return model;
    }

    public void step(Main main, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(main, action, time);
        viewer.draw(gui);
    }
}