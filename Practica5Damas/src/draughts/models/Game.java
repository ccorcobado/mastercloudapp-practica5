package draughts.models;

import draughts.types.Error;

public class Game {

    public Turn getTurn() {
        return new Turn();
    }
    
    public Error move(Coordinate origin, Coordinate target){
        return Error.DEFAULT;
    }
    
    public Piece getPiece(Coordinate origin) {
        return new Pawn();
    }
}
