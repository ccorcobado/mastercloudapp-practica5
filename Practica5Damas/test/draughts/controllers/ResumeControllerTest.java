package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.StateValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ResumeControllerTest extends ControllerTest {
    
    private ResumeController resumeController;
    
    public ResumeControllerTest() {}
    
    @Before
    @Override
    public void init() {
        this.game = new Game();
        this.state = new State();
        this.resumeController = new ResumeController(this.game, this.state);
    }
    
    @Test
    public void givenResumeControllerWhenContinueThenNotError() {
        this.resumeController.resume(true);
        assertEquals(this.state.getValue(), StateValue.INITIAL);
    }
    
    @Test
    public void givenResumeControllerWhenExitThenNotError() {
        this.resumeController.resume(false);
        assertEquals(this.state.getValue(), StateValue.EXIT);
    }
}