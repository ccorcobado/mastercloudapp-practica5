package draughts.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class SquareTest {

    private Square getSquareWithoutPiece() {
        return new Square(Board.MIN, Board.MIN);
    }
    
    private Square getSquareWithPiece() {
        Square square = this.getSquareWithoutPiece();
        Piece pawn = new Pawn();
        square.addPiece(pawn);
        return square;
    }
    
    @Test
    public void givenSquareWhenIsTopLimitThenNotError() {
        Square square = new Square(Board.MIN, Board.MIN);
        assertEquals(square.getCoordinate().getRow(), Board.MIN);
    }
    
    @Test
    public void givenSquareWhenIsDownLimitThenNotError() {
        Square square = new Square(Board.MAX, Board.MIN);
        assertEquals(square.getCoordinate().getRow(), Board.MAX);
    }
    
    @Test
    public void givenSquareWhenIsLeftLimitThenNotError() {
        Square square = new Square(Board.MIN, Board.MIN);
        assertEquals(square.getCoordinate().getColumn(), Board.MIN);
    }
    
    @Test
    public void givenSquareWhenIsRightLimitThenNotError() {
        Square square = new Square(Board.MIN, Board.MAX);
        assertEquals(square.getCoordinate().getColumn(), Board.MAX);
    }
    
    @Test
    public void givenSquareWhenHasAPieceThenNotError() {
        Square square = this.getSquareWithPiece();
        Piece piece = square.getPiece();
        assertNotNull(piece);
    }
    
    @Test
    public void givenSquareWhenAddingPieceThenNotError() {
        Square square = this.getSquareWithoutPiece();
        Piece piece = square.getPiece();
        assertNull(piece);
        Piece pawn = new Pawn();
        square.addPiece(pawn);
        piece = square.getPiece();
        assertNotNull(piece);
    }
    
    @Test
    public void givenSquareWhenRemovingPieceThenNotError() {
        Square square = this.getSquareWithPiece();
        Piece piece = square.getPiece();
        assertNotNull(piece);
        square.removePiece();
        piece = square.getPiece();
        assertNull(piece);
    }
}