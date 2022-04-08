package pl.edu.agh.to2.cardgame.model.slot;

import pl.edu.agh.to2.cardgame.model.cardSet.Deck;

public class DeckSlot extends Slot<Deck> {

    public DeckSlot(int number, Deck cardSet) {
        super(number, cardSet);
    }

    public String toString(){
        return String.format("Deck %d", this.getNumber());
    }
}
