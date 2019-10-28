package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;

abstract class ControllerTest {
    
    protected Game game;
    protected State state;
    
    public abstract void init();
}
