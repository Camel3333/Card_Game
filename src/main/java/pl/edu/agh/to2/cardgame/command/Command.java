package pl.edu.agh.to2.cardgame.command;

public interface Command {
    void execute();
    void undo();
    void redo();
    String getName();
}
