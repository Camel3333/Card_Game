package pl.edu.agh.to2.cardgame.model.card;

public class CardData {
    private Suit suit;
    private Rank rank;

    public CardData(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
}
