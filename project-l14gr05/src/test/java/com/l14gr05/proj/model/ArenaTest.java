package com.l14gr05.proj.model;

import com.l14gr05.proj.model.game.arena.Arena;
import com.l14gr05.proj.model.game.elements.Floor;
import com.l14gr05.proj.model.game.elements.Puffle;
import com.l14gr05.proj.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public class ArenaTest {
    private Arena arena;
    private Puffle puffle;
    @BeforeEach
    void setup(){
        arena = new Arena(10,10,1,0);

        puffle = new Puffle(5,5);
        arena.setPuffle(puffle);
    }

    @Test
    void setWidth(){
        arena.setWidth(15);
        assertEquals(15, arena.getWidth());
    }

    @Test
    void setHeight(){
        arena.setHeight(15);
        assertEquals(15, arena.getHeight());
    }

    @Test
    void canMoveTrue(){
        arena.setFloors(Arrays.asList(new Floor(5,6,1,false), new Floor(6,5,1,false),
                new Floor(5,4,1,false), new Floor(4,5,1,false)));
        arena.setWalls(Arrays.asList(new Wall(6,6)));

        assertEquals(true, arena.canMove(puffle.getPosition()));
    }
    @Test
    void canMoveFalse(){
        arena.setWalls(Arrays.asList(new Wall(5,6), new Wall(6,5), new Wall(5,4), new Wall(4,5)));

        assertEquals(false, arena.canMove(puffle.getPosition()));
    }

    @Test
    void reachObjectiveTrue(){
        arena.setFloors(Arrays.asList(new Floor(5,5,1, true)));

        assertEquals(true, arena.reachObjective());
    }

    @Test
    void reachObjectiveFalse(){
        arena.setFloors(Arrays.asList(new Floor(5,5,1, false), new Floor(5,6,1,true)));

        assertEquals(false, arena.reachObjective());
    }
}
