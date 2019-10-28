package draughts.models;

import draughts.types.Color;

public class Square {

    public Square(int row, int column) {}
    
    public Coordinate getCoordinate() {
        return new Coordinate(0, 0);
    }

    public Color getColor() {
        return Color.WHITE;
    }

    public Piece getPiece() {
        return new Pawn();
    }

    public void addPiece(Piece pawn) {
        
    }

    public void removePiece() {
        
    }
}
