package draughts.models;

import draughts.types.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class GameTest {
    
    private Game game;
    
    public GameTest() { }

    @Before
    public void init() {
        this.game = new Game();
    }
    
    @Test
    public void givenGameWhenMovementRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);

        assertNull(this.game.move(origin, target));
        assertNull(this.game.getPiece(origin));
        Piece pieceTarget = this.game.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
    
    @Test
    public void givenGameWhenMovementIsOutOfBoardArrangeThenNotError() {
        Coordinate origin = new Coordinate(6, 7);
        Coordinate target = new Coordinate(5, 9);
        
        assertNotNull(this.game.move(origin, target));
        assertNotNull(this.game.getPiece(origin));
        Piece pieceTarget = this.game.getPiece(target);
        assertNull(pieceTarget);
    }
    
    @Test
    public void givenGameWhenMovementHasNotAnEmptyTargetThenNotError() {
        Coordinate origin = new Coordinate(4, 0);
        Coordinate target = new Coordinate(5, 2);
        
        assertNotNull(this.game.getPiece(target));
        assertNotNull(this.game.move(origin, target));
    }
    
    @Test
    public void givenGameWhenMovementHasAnEmptyOriginThenNotError() {
        Coordinate origin = new Coordinate(4, 0);
        Coordinate target = new Coordinate(3, 1);
        
        assertNull(this.game.getPiece(origin));
        assertNotNull(this.game.move(origin, target));
    }
    
    @Test
    public void givenGameWhenMovementIsOutOfTurnColorThenNotError() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 0);
        
        assertNotNull(this.game.move(origin, target));
        assertEquals(this.game.getTurn().getColor(), Color.WHITE);
        Piece pieceOrigin = this.game.getPiece(origin);
        assertNotNull(pieceOrigin);
        assertEquals(pieceOrigin.getColor(), Color.BLACK);
    }
    
    @Test
    public void givenGameWhenBlackTurnThenNotError() {
        this.givenGameWhenWhiteTurnThenNotError();
        this.game.getTurn().next();
        assertEquals(this.game.getTurn().getColor(), Color.BLACK);
    }
    
    @Test
    public void givenGameWhenWhiteTurnThenNotError() {
        assertEquals(this.game.getTurn().getColor(), Color.WHITE);
    }
}