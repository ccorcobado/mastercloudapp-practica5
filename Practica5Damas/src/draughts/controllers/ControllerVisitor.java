package draughts.controllers;

public interface ControllerVisitor {
    
    public void visit(StartController startController);
    public void visit(PlayController playController);
    public void visit(ResumeController resumeController);
}