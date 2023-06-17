import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.io.IOException;

public class Game {

    Arena arena = new Arena(60, 60);

    public Screen screen;

    public Game(){
        try{
            TerminalSize terminalSize = new TerminalSize(80, 80);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(){
        screen.clear();
        //screen.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
        arena.draw(screen.newTextGraphics());
        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    KeyStroke key;
    public void run(){
        while(true){
            draw();
            try {
                key = screen.readInput();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            processKey(key);
            if(arena.verifyMonsterCollisions()){
                try {
                    screen.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("You died!");
            }

            if(key.getKeyType() == KeyType.Character && key.getCharacter()=='q'){
                try {
                    screen.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if(key.getKeyType() == KeyType.EOF){
                try {
                    screen.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            arena.moveMonsters();
            if(arena.verifyMonsterCollisions()){
                try {
                    screen.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("You died!");
            }

        }
    }

    private void processKey(KeyStroke key){
        arena.processKey(key);
    }
}
