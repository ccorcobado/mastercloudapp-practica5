package draughts.controllers;

import draughts.models.Game;
import draughts.models.State;
import draughts.models.StateValue;
import java.util.HashMap;
import java.util.Map;

public class Logic {
    
    private final State state;
    private final Game game;
    private final Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.game = new Game();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_PLAY, new PlayController(this.game, this.state));
        this.controllers.put(StateValue.IN_RESUME, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValue());
    }
}