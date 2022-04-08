package pl.edu.agh.to2.cardgame.model.cardSet;

import javafx.collections.ObservableList;
import pl.edu.agh.to2.cardgame.model.card.Card;

import java.util.List;

public interface CardSet {
    ObservableList<Card> getCards();
    Card getCard();
    Card takeCard();
    void addCard(Card card);
    void addCards(List<Card> cards);
    boolean isEmpty();
    void shuffle();
    void clear();
}
