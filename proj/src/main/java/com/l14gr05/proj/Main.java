package com.l14gr05.proj;

import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.model.menu.MainMenu;
import com.l14gr05.proj.states.MainMenuState;
import com.l14gr05.proj.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private LanternaGUI gui;
    private State state;

    public Main() throws IOException, URISyntaxException, FontFormatException {
        this.gui= new LanternaGUI(40, 40);
        this.state= new MainMenuState(new MainMenu());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Main().start();
    }

    public void setState(State state){
        this.state=state;
    }

    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}