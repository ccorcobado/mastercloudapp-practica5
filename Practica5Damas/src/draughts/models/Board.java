package draughts.models;

import draughts.types.Color;
import draughts.types.Error;

public class Board {

    public static final int MIN = 0;
    public static final int MAX = 7;
    
    public int length() {
        return MAX;
    }

    public Square getSquare(int i, int j) {
        return new Square(i, j);
    }

    public Error move(Coordinate origin, Coordinate target) {
        return Error.DEFAULT;
    }

    public Piece getPiece(Coordinate origin) {
        return new Pawn();
    }

    public boolean hasAnyMovement(Color color) {
        return false;
    }
}
