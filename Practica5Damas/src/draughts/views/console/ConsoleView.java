package draughts.views.console;

import draughts.controllers.Controller;
import draughts.controllers.PlayController;
import draughts.controllers.ResumeController;
import draughts.controllers.StartController;
import draughts.views.View;

public class ConsoleView extends View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    } 

    @Override
    public void visit(StartController startController) {
        
    }

    @Override
    public void visit(PlayController playController) {
        
    }

    @Override
    public void visit(ResumeController resumeController) {
        
    }
}
