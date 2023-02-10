package com.l14gr05.proj.states;

import com.l14gr05.proj.controller.Controller;
import com.l14gr05.proj.controller.game.ArenaController;
import com.l14gr05.proj.model.game.arena.Arena;
import com.l14gr05.proj.viewer.Viewer;
import com.l14gr05.proj.viewer.game.GameViewer;

public class GameState extends State<Arena>{
    public GameState(Arena arena){
        super(arena);
    }

    @Override
    public Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    public Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}