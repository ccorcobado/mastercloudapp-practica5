package draughts.models;

import draughts.types.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TurnTest {
    
    private Turn turn;
    
    public TurnTest() {}
    
    @Before
    public void init() {
        this.turn = new Turn();
    }
    
    @Test
    public void givenTurnWhenStartIsWhiteThenNotError() {
        assertEquals(this.turn.getColor(), Color.WHITE);
    }
    
    @Test
    public void givenTurnWhenChangeIsDifferentFromBeforeThenNotError() {
        this.givenTurnWhenStartIsWhiteThenNotError();
        this.turn.next();
        assertEquals(this.turn.getColor(), Color.BLACK);
    }
}
