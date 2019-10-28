package draughts.views;

import draughts.controllers.Controller;
import draughts.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor {
    
    public abstract void interact(Controller controller);
}