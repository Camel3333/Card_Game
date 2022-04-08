package pl.edu.agh.to2.cardgame.controller;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.to2.cardgame.model.card.Card;
import pl.edu.agh.to2.cardgame.model.slot.Slot;
import pl.edu.agh.to2.cardgame.util.CardImageService;

public abstract class SlotController<T extends Slot> {
    private T slot;
    private ObservableList<Card> cards;
    private TableController tableController;
    private int CARD_HEIGHT = 80;
    private int Y_OFFSET = -4;

    @Autowired
    private CardImageService cardImageService;

    @FXML
    private StackPane slotView;

    public void setModel(T slot, TableController tableController, boolean isFullShown){
        this.slot = slot;
        cards = slot.getCardSet().getCards();
        drawCardSet(isFullShown);
        cards.addListener((ListChangeListener.Change<? extends Card> change) -> {
            while (change.next()) {
                if (change.wasReplaced()) {
                    drawCardSet(isFullShown);
                }
                else if (change.wasRemoved()) {
                    removeCards(change.getRemoved().size(), isFullShown);
                }
                else if(change.wasAdded()){
                    addCards(change.getAddedSubList().size(), isFullShown);
                }
            }
        });
        this.tableController = tableController;
    }

    public void setModel(T slot, TableController tableController){
        this.setModel(slot, tableController, false);
    }

    private void addCards(int amount, boolean isFullShown) {
        if(!slotView.getChildren().isEmpty() && !isFullShown) {
            slotView.getChildren().remove(slotView.getChildren().size() - 1);
            slotView.getChildren().add(createImageView(cards.size() - 1 - amount, false));
        }
        for(int i = amount; i >= 2; i--) {
            slotView.getChildren().add(createImageView(cards.size() - i, isFullShown));
        }
        slotView.getChildren().add(createImageView(cards.size() - 1, true));
    }

    private void removeCards(int amount, boolean isFullShown) {
        if(slotView.getChildren().isEmpty()) {
            return;
        }
        for(int i = 1; i <= amount; i++) {
            slotView.getChildren().remove(slotView.getChildren().size() - i);
        }
        if(!slotView.getChildren().isEmpty() && !isFullShown) {
            slotView.getChildren().remove(slotView.getChildren().size() - 1);
            slotView.getChildren().add(createImageView(cards.size() - 1, true));
        }
    }

    private void drawCardSet(boolean isFullShown) {
        slotView.getChildren().clear();
        if(slot.getCardSet().isEmpty()) {
            return;
        }
        for(int i = 0; i < cards.size() - 1; i++){
            slotView.getChildren().add(createImageView(i, isFullShown));
        }
        slotView.getChildren().add(createImageView(cards.size() - 1, true));
    }

    private ImageView createImageView(int cardIndex, boolean isFullShown) {
        ImageView imageView;
        if(isFullShown) {
            imageView = new ImageView(cardImageService.getImage(cards.get(cardIndex)));
        }
        else {
            imageView = new ImageView(cardImageService.getReverse());
        }
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(CARD_HEIGHT);
        imageView.setTranslateY(Y_OFFSET * cardIndex);
        return imageView;
    }

    public T getSlot(){
        return slot;
    }

    public TableController getTableController(){
        return tableController;
    }

    public void setCardHeight(int cardHeight){
        this.CARD_HEIGHT = cardHeight;
    }

    public void setYOffset(int YOffset){
        this.Y_OFFSET = YOffset;
    }

    public abstract void handleSlotClicked(MouseEvent mouseEvent);
}
