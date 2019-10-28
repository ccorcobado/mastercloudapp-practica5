package draughts;

import draughts.controllers.Controller;
import draughts.controllers.Logic;
import draughts.views.View;
import draughts.views.console.ConsoleView;

public class Draughts {
    
    private final Logic logic;
    private final View view;

    private Draughts() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    public static void main(String[] args) {
        new Draughts().play();
    }

    public void play() {
        Controller controller;
        
        do {
            controller = this.logic.getController();
            if (controller != null)
                this.view.interact(controller);
        } while (controller != null);
    }
}
