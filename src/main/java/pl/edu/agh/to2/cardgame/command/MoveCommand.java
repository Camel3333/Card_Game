package pl.edu.agh.to2.cardgame.command;

import pl.edu.agh.to2.cardgame.model.Table;
import pl.edu.agh.to2.cardgame.model.slot.Slot;

public class MoveCommand implements Command {
    private Table table;
    private Slot oldSlot;
    private Slot newSlot;
    private String cardName;

    public MoveCommand(Table table, Slot oldSlot, Slot newSlot) {
        this.table = table;
        this.oldSlot = oldSlot;
        this.newSlot = newSlot;

        cardName = oldSlot.getCardSet().getCard().toString();
    }

    @Override
    public void execute() {
        table.move(oldSlot, newSlot);
    }

    @Override
    public void undo() {
        table.move(newSlot, oldSlot);
    }

    @Override
    public void redo() {
        execute();
    }

    @Override
    public String getName() {
        return String.format("Moved %s from %s to %s", cardName, oldSlot, newSlot);
    }
}
