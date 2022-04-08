package pl.edu.agh.to2.cardgame.model.cardSet;

public class Stack extends CardSetDecorator {
    private boolean fullShown;

    public Stack(CardSet cardSet, boolean fullShown) {
        super(cardSet);
        this.fullShown = fullShown;
    }

    public boolean isFullShown() {
        return fullShown;
    }
}
