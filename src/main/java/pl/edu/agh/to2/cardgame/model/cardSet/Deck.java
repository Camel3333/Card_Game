package pl.edu.agh.to2.cardgame.model.cardSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.to2.cardgame.model.card.Card;
import pl.edu.agh.to2.cardgame.util.Shuffler;

import java.util.List;

public class Deck implements CardSet {

    private final ObservableList<Card> cards = FXCollections.observableArrayList();

    public Deck(){
    }

    public Deck(List<Card> cards){
        addCards(cards);
    }

    @Override
    public ObservableList<Card> getCards() {
        return cards;
    }

    @Override
    public Card getCard() {
        if(isEmpty()) {
            return null;
        }
        return cards.get(cards.size() - 1);
    }

    @Override
    public Card takeCard() {
        if(isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public void shuffle() {
        new Shuffler().shuffle(this);
    }

    @Override
    public void clear() {
        cards.clear();
    }
}
