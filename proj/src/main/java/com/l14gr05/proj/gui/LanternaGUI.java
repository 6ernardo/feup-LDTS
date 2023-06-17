package com.l14gr05.proj.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.l14gr05.proj.model.game.Position;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI{

    private Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfiguration = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfiguration);
        this.screen = createScreen(terminal);
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfiguration) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width,height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        Terminal terminal = terminalFactory.createTerminal();

        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException{
        Screen screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        return screen;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, IOException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("font.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public ACTION getNextAction() throws IOException{
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawPuffle(Position position){
        drawCharacters(position.getX(), position.getY(), 'Ú', "#FF0000", "#61DBFF");
    }

    @Override
    public void drawWall(Position position){
        drawCharacters(position.getX(), position.getY(), 'À', "#4444FF", "#2F2FFF");
    }

    @Override
    public void drawFloor(Position position, int durability, boolean objective){
        String color;
        if(objective) color="#FF3C00";
        else if(durability==2) color="#AFEDFF";
        else if(durability==1) color="#61DBFF";
        else color="#080EA9";

        drawCharacters(position.getX(), position.getY(), 'O', color, color);
    }

    @Override
    public void drawCoin(Position position){
        drawCharacters(position.getX(), position.getY(), 'Ò', "#FFFF00", "#61DBFF");
    }

    @Override
    public void drawKey(Position position){
        drawCharacters(position.getX(), position.getY(), 'È', "#FFFF00", "#61DBFF");
    }

    @Override
    public void drawLock(Position position){
        drawCharacters(position.getX(), position.getY(), 'Ì', "#000000","#FFAB00");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacters(int x, int y, char c, String foreground, String background){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(foreground));
        tg.setBackgroundColor(TextColor.Factory.fromString(background));
        tg.enableModifiers(SGR.BOLD);
        tg.putString(new TerminalPosition(x+10, y+10), ""+c);
    }

    @Override
    public void clear(){
        screen.clear();
    }

    @Override
    public void refresh() throws IOException{
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }


}
