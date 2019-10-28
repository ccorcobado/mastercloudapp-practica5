package draughts.controllers;

import draughts.models.Coordinate;
import draughts.models.Game;
import draughts.models.Piece;
import draughts.models.State;
import draughts.models.StateValue;
import draughts.types.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/*
    01234567
   0 n n n n0
   1n n n n 1
   2 n n n n2
   3        3
   4        4
   5b b b b 5
   6 b b b b6
   7b b b b 7
    01234567
*/
public class PlayControllerTest extends ControllerTest {
    
    private PlayController playController;
    
    public PlayControllerTest() { }

    @Before
    @Override
    public void init() {
        this.game = new Game();
        this.state = new State();
        this.playController = new PlayController(this.game, this.state);
    }
    
    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);

        assertNull(this.playController.move(origin, target));
        assertNull(this.playController.getPiece(origin));
        Piece pieceTarget = this.playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
    
    @Test
    public void givenPlayControllerWhenMovementIsInvalidThenNotError() {
        Coordinate origin = null;
        Coordinate target = new Coordinate(24, 52);
        
        assertNotNull(this.playController.move(origin, target));
        Piece pieceTarget = this.playController.getPiece(target);
        assertNull(pieceTarget);
    }
    
    @Test
    public void givenPlayControllerWhenMovementIsOutOfBoardArrangeThenNotError() {
        Coordinate origin = new Coordinate(6, 7);
        Coordinate target = new Coordinate(5, 9);
        
        assertNotNull(this.playController.move(origin, target));
        assertNotNull(this.playController.getPiece(origin));
        Piece pieceTarget = this.playController.getPiece(target);
        assertNull(pieceTarget);
    }
    
    @Test
    public void givenPlayControllerWhenMovementHasNotAnEmptyTargetThenNotError() {
        Coordinate origin = new Coordinate(4, 0);
        Coordinate target = new Coordinate(5, 2);
        
        assertNotNull(this.playController.getPiece(target));
        assertNotNull(this.playController.move(origin, target));
    }
    
    @Test
    public void givenPlayControllerWhenMovementHasAnEmptyOriginThenNotError() {
        Coordinate origin = new Coordinate(4, 0);
        Coordinate target = new Coordinate(3, 1);
        
        assertNull(this.playController.getPiece(origin));
        assertNotNull(this.playController.move(origin, target));
    }
    
    @Test
    public void givenPlayControllerWhenMovementDistanceIsOutOfLimitThenNotError() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(3, 1);
        
        assertNotNull(this.playController.move(origin, target));
        int diffBetweenRows = Math.abs(origin.getRow() - target.getRow());
        assertTrue(diffBetweenRows > 1);
    }
    
    @Test
    public void givenPlayControllerWhenMovementIsOutOfTurnColorThenNotError() {
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 0);
        
        assertNotNull(this.playController.move(origin, target));
        assertEquals(this.playController.getTurn().getColor(), Color.WHITE);
        Piece pieceOrigin = this.playController.getPiece(origin);
        assertNotNull(pieceOrigin);
        assertEquals(pieceOrigin.getColor(), Color.BLACK);
    }
    
    @Test
    public void givenPlayControllerWhenMovementCorrectBlackTurnThenNotError() {
        this.givenPlayControllerWhenMovementRequiereCorrectThenNotError();
        
        assertEquals(this.playController.getTurn().getColor(), Color.BLACK);
    }
    
    private void assertPieceBlocked(Coordinate origin, Coordinate target) {
        assertNotNull(this.playController.move(origin, target));
        Piece pieceTarget = this.playController.getPiece(target);
        assertNotNull(pieceTarget);
    }
    
    @Test
    public void givenPlayControllerWhenMovementPieceBlockedThenNotError() {
        Coordinate origin = new Coordinate(6, 3);
        Coordinate targetUpLeft = new Coordinate(5, 2);
        Coordinate targetUpRight = new Coordinate(5, 4);
        Coordinate targetDownLeft = new Coordinate(7, 2);
        Coordinate targetDownRight = new Coordinate(7, 4);
        
        Piece pieceOrigin = this.playController.getPiece(origin);
        assertNotNull(pieceOrigin);
        assertEquals(pieceOrigin.getColor(), Color.WHITE);
        
        this.assertPieceBlocked(origin, targetUpLeft);
        this.assertPieceBlocked(origin, targetUpRight);
        this.assertPieceBlocked(origin, targetDownLeft);
        this.assertPieceBlocked(origin, targetDownRight);
    }
    
    @Test
    public void givenPlayControllerWhenMovementCancelThenNotError() {
        this.playController.cancel();
        assertEquals(this.state.getValue(), StateValue.IN_RESUME);
    }
}