package pl.edu.agh.to2.cardgame.model.card;

public class Card {
    private CardData cardData;

    public Card(CardData cardData){
        this.cardData = cardData;
    }

    public CardData getData(){
        return cardData;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", cardData.getRank(), cardData.getSuit());
    }

    public boolean isSameColor(Card card) {
        return cardData.getSuit().isSameColor(card.getData().getSuit());
    }

    public boolean isSameSuit(Card card) {
        return cardData.getSuit() == card.getData().getSuit();
    }

    private int compareRank(Card card) {
        return cardData.getRank().compareRank(card.getData().getRank());
    }

    public boolean isHigher(Card card) {
        return compareRank(card) > 0;
    }

    public boolean isLower(Card card) {
        return compareRank(card) < 0;
    }

    public boolean isSameRank(Card card) {
        return compareRank(card) == 0;
    }

    public boolean isHigherOrSameRank(Card card) {
        return compareRank(card) >= 0;
    }

    public boolean isLowerOrSameRank(Card card) {
        return compareRank(card) <= 0;
    }
}
