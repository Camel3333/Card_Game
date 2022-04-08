package pl.edu.agh.to2.cardgame.model.card;

import java.lang.IllegalArgumentException;

public enum Suit {
    CLUBS,
    SPADES,
    DIAMONDS,
    HEARTS;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public boolean isSameColor(Suit suit) {
        switch (this) {
            case CLUBS, SPADES -> {
                return suit == CLUBS || suit == SPADES;
            }
            case DIAMONDS, HEARTS -> {
                return suit == DIAMONDS || suit == HEARTS;
            }
        }
        throw new IllegalArgumentException();
    }
}