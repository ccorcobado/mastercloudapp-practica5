package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;

public class MoveController extends Controller {

    public MoveController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        
    }
}