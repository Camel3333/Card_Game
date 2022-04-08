package pl.edu.agh.to2.cardgame.model.cardSet;

import org.springframework.stereotype.Component;
import pl.edu.agh.to2.cardgame.model.card.Card;
import pl.edu.agh.to2.cardgame.model.card.CardData;
import pl.edu.agh.to2.cardgame.model.card.Rank;
import pl.edu.agh.to2.cardgame.model.card.Suit;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardSetFactory {

    public CardSetFactory() { }

    public Deck createDeck() {
        List<Card> cards = new ArrayList<>();

        for(Suit suit : Suit.values()) {
            for(Rank rank : Rank.values()) {
                cards.add(new Card(new CardData(suit, rank)));
            }
        }

        return new Deck(cards);
    }

    public Stack createStack(boolean fullShown) {
        return new Stack(new Deck(), fullShown);
    }
}
