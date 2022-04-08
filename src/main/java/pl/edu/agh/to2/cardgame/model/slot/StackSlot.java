package pl.edu.agh.to2.cardgame.model.slot;

import pl.edu.agh.to2.cardgame.model.cardSet.Stack;

public class StackSlot extends Slot<Stack> {

    public StackSlot(int number, Stack stack) {
        super(number, stack);
    }

    public boolean isFullShown() {
        return getCardSet().isFullShown();
    }

    public String toString(){
        return String.format("Stack %d", getNumber());
    }
}
