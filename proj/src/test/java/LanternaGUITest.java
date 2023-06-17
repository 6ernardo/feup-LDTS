package com.l14gr05.proj;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.l14gr05.proj.gui.LanternaGUI;
import com.l14gr05.proj.model.game.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() throws IOException {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }
    @Test
    void drawPuffle() {
        gui.drawPuffle(new Position(20, 20));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(new TextColor.RGB(97,219,255));
        Mockito.verify(tg,Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(30, 30), "Ú");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#FFFFFF");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

}

