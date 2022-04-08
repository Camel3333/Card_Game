package pl.edu.agh.to2.cardgame.util;

import javafx.collections.FXCollections;
import pl.edu.agh.to2.cardgame.model.cardSet.CardSet;

public final class Shuffler {

    public Shuffler() {
    }

    public void shuffle(CardSet cardSet) {
        FXCollections.shuffle(cardSet.getCards());
    }
}
