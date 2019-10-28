package draughts.models;

import draughts.types.Color;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
        
    private final FactoryBoard factory;
    
    public BoardTest() {
        this.factory = new FactoryBoard();
    }
    
    @Test
    public void givenBoardWhenMovementCorrectThenNotError() {
        Board board = this.factory.get(FactoryBoard.BoardType.BOARD_INITIAL);
        
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);

        assertNull(board.move(origin, target));
        assertNull(board.getPiece(origin));
        Piece pieceTarget = board.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
    
    @Test
    public void givenBoardWhenMovementBlackBlockedThenNotError() {
        Board board = this.factory.get(FactoryBoard.BoardType.BOARD_BLACK_BLOCK);
        assertFalse(board.hasAnyMovement(Color.BLACK));
        assertTrue(board.hasAnyMovement(Color.WHITE));
    }
    
    @Test
    public void givenBoardWhenMovementWhiteBlockedThenNotError() {
        Board board = this.factory.get(FactoryBoard.BoardType.BOARD_WHITE_BLOCK);
        assertFalse(board.hasAnyMovement(Color.WHITE));
        assertTrue(board.hasAnyMovement(Color.BLACK));
    }
    
    @Test
    public void givenBoardWhenDrawThenNotError() {
        Board board = this.factory.get(FactoryBoard.BoardType.BOARD_DRAW);
        assertFalse(board.hasAnyMovement(Color.WHITE));
        assertFalse(board.hasAnyMovement(Color.BLACK));
    }
    
    private void givenBoardWhenUnknownPawnToDamaThenNotError(Piece pieceOrigin, Piece pieceTarget, Color colorToCompare) {
        assertNull(pieceOrigin);
        
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), colorToCompare);
        assertTrue(pieceTarget instanceof Dama);
    }
    
    @Test
    public void givenBoardWhenBlackPawnToDamaThenNotError() {
        Board board = this.factory.get(FactoryBoard.BoardType.BOARD_BLACK_PAWN_TO_DAMA);
        
        // we assume that:
        //  - black pawn is x=5 y=2
        //  - white pawn is x=6 y=1
        Coordinate origin = new Coordinate(5, 2);
        Coordinate target = new Coordinate(6, 1);
        
        
        assertNull(board.move(origin, target));
        Piece pieceOrigin = board.getPiece(origin);
        Piece pieceTarget = board.getPiece(target);
        this.givenBoardWhenUnknownPawnToDamaThenNotError(pieceOrigin, pieceTarget, Color.BLACK);
    }
    
    @Test
    public void givenBoardWhenWhitePawnToDamaThenNotError() {
        Board board = this.factory.get(FactoryBoard.BoardType.BOARD_WHITE_PAWN_TO_DAMA);
        
        // we assume that:
        //  - black pawn is x=2 y=1
        //  - white pawn is x=0 y=3
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(0, 3);
        
        assertNull(board.move(origin, target));
        Piece pieceOrigin = board.getPiece(origin);
        Piece pieceTarget = board.getPiece(target);
        this.givenBoardWhenUnknownPawnToDamaThenNotError(pieceOrigin, pieceTarget, Color.WHITE);
    }
}
