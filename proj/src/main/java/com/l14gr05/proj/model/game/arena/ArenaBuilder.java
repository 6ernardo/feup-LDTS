package com.l14gr05.proj.model.game.arena;

import com.l14gr05.proj.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArenaBuilder {
    private int level;
    private int score;
    private List<String> lines;

    public ArenaBuilder(int level, int score) throws IOException {
        this.level=level;
        this.score=score;

        URL resource = ArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    public Arena createArena(){
        Arena arena = new Arena(40,40, level, score);

        arena.setPuffle(createPuffle());
        arena.setWalls(createWalls());
        arena.setLock(createLock());
        arena.setKey(createKey());
        arena.setCoin(createCoin());
        arena.setFloors(createFloors());

        return arena;
    }

    private Puffle createPuffle(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'P') return new Puffle(x, y);
        }

        return null;
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    private List<Floor> createFloors(){
        List<Floor> floors = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == '1') floors.add(new Floor(x, y, 1, false));
                else if (line.charAt(x) == '2') floors.add(new Floor(x, y, 2, false));
                else if (line.charAt(x) == 'O') floors.add(new Floor(x, y, 1, true));
                else if(line.charAt(x) == 'P') floors.add(new Floor(x,y,1,false));
                else if(line.charAt(x) == 'K') floors.add(new Floor(x,y,1,false));
                else if(line.charAt(x) == 'C') floors.add(new Floor(x,y,1,false));
            }
        }

        return floors;
    }

    private Key createKey(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'K') return new Key(x, y);
        }

        return null;
    }

    private Coin createCoin(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'C') return new Coin(x, y);
        }

        return null;
    }

    private Lock createLock(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'L') return new Lock(x, y);
        }

        return null;
    }

}
