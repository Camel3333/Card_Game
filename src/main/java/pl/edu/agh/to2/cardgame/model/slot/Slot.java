package pl.edu.agh.to2.cardgame.model.slot;

import pl.edu.agh.to2.cardgame.model.card.Card;
import pl.edu.agh.to2.cardgame.model.cardSet.CardSet;

public abstract class Slot<T extends CardSet> {
    private final T cardSet;
    private final int number;

    public Slot(int number, T cardSet) {
        this.number = number;
        this.cardSet = cardSet;
    }

    public void put(Card card) {
        cardSet.addCard(card);
    }

    public Card take() {
        return cardSet.takeCard();
    }

    public T getCardSet() {
        return cardSet;
    }

    public int getNumber(){
        return number;
    }

    public abstract String toString();

}