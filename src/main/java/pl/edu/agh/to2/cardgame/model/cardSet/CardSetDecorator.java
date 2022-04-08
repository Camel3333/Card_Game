package pl.edu.agh.to2.cardgame.model.cardSet;

import javafx.collections.ObservableList;
import pl.edu.agh.to2.cardgame.model.card.Card;

import java.util.List;

public abstract class CardSetDecorator implements CardSet {
    protected CardSet cardSet;

    public CardSetDecorator(CardSet cardSet) {
        this.cardSet = cardSet;
    }

    @Override
    public ObservableList<Card> getCards() {
        return cardSet.getCards();
    }

    @Override
    public Card getCard() {
        return cardSet.getCard();
    }

    @Override
    public Card takeCard() {
        return cardSet.takeCard();
    }

    @Override
    public void addCard(Card card) {
        cardSet.addCard(card);
    }

    @Override
    public void addCards(List<Card> cards) {
        cardSet.addCards(cards);
    }

    @Override
    public boolean isEmpty() {
        return cardSet.isEmpty();
    }

    @Override
    public void shuffle() {
        cardSet.shuffle();
    }

    @Override
    public void clear() {
        cardSet.clear();
    }
}
