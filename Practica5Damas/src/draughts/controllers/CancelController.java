package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;

public class CancelController extends Controller {

    public CancelController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        
    }
}
