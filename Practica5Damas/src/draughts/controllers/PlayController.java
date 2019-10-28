package draughts.controllers;

import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.State;
import draughts.types.Error;

public class PlayController extends Controller {

    protected final MoveController moveController;
    protected final CancelController cancelController;
    
    public PlayController(Game game, State state) {
        super(game, state);
        this.moveController = new MoveController(game, state);
        this.cancelController = new CancelController(game, state);
    }
    
    public Error move(Coordinate origin, Coordinate target){
        return Error.DEFAULT;
    }
    
    public void cancel() {
        
    }
    
    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
