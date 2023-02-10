package com.l14gr05.proj.controller.game;

import com.l14gr05.proj.controller.Controller;
import com.l14gr05.proj.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
