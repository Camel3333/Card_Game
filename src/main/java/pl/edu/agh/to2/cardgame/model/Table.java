package pl.edu.agh.to2.cardgame.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.edu.agh.to2.cardgame.model.slot.DeckSlot;
import pl.edu.agh.to2.cardgame.model.slot.Slot;
import pl.edu.agh.to2.cardgame.model.slot.StackSlot;


public class Table {
    private ObservableList<StackSlot> stackSlots = FXCollections.observableArrayList();
    private ObservableList<DeckSlot> deckSlots = FXCollections.observableArrayList();

    public Table(){ }

    public Table(ObservableList<StackSlot> stackSlots, ObservableList<DeckSlot> deckSlots) {
        this.stackSlots = stackSlots;
        this.deckSlots = deckSlots;
    }

    public void move(Slot oldSlot, Slot newSlot) {
        newSlot.put(oldSlot.take());
    }

    public boolean validateMove(Slot oldSlot, Slot newSlot) {
        return !oldSlot.getCardSet().isEmpty();
    }

    public ObservableList<DeckSlot> getDecks() {
        return deckSlots;
    }

    public void addDeck(DeckSlot deckSlot) {
        deckSlots.add(deckSlot);
    }

    public ObservableList<StackSlot> getSlots() {
        return stackSlots;
    }

    public void addSlot(StackSlot stackSlot) {
        stackSlots.add(stackSlot);
    }
}