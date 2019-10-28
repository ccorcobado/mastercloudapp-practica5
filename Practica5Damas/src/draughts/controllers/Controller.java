package draughts.controllers;

import draughts.models.Board;
import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.Piece;
import draughts.models.Pawn;
import draughts.models.State;
import draughts.models.Turn;

public abstract class Controller {
    
    protected final Game game;
    protected final State state;
    
    protected Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }
    
    public Turn getTurn() {
        return new Turn();
    }

    public Board getBoard() {
        return new Board();
    }

    public Piece getPiece(Coordinate origin) {
        return new Pawn();
    }
    
    public abstract void accept(ControllerVisitor controllerVisitor);
}
