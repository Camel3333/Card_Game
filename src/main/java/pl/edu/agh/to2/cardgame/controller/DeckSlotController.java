package pl.edu.agh.to2.cardgame.controller;

import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.agh.to2.cardgame.model.slot.DeckSlot;

@Component
@Scope("prototype")
@FxmlView("/view/deckslotView.fxml")
public class DeckSlotController extends SlotController<DeckSlot>{

    private final int CARD_HEIGHT = 80;
    private final int Y_OFFSET = -4;

    public DeckSlotController() {
        setCardHeight(CARD_HEIGHT);
        setYOffset(Y_OFFSET);
    }

    public void handleSlotClicked(MouseEvent mouseEvent) {
        if(getTableController().getSelectedCard() == null && !getSlot().getCardSet().isEmpty()) {
            getTableController().setSelectedCard(getSlot().getCardSet().getCard());
            getTableController().setSelectedSlot(getSlot());
        }
    }
}
