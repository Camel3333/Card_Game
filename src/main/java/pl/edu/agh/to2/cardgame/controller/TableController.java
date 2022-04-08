package pl.edu.agh.to2.cardgame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.to2.cardgame.command.CommandRegistry;
import pl.edu.agh.to2.cardgame.command.Command;
import pl.edu.agh.to2.cardgame.command.MoveCommand;
import pl.edu.agh.to2.cardgame.model.slot.Slot;
import pl.edu.agh.to2.cardgame.model.slot.StackSlot;
import pl.edu.agh.to2.cardgame.model.Table;
import pl.edu.agh.to2.cardgame.model.card.Card;
import pl.edu.agh.to2.cardgame.util.CardImageService;

@Component
@FxmlView("/view/tableView.fxml")
public class TableController {

    private final Table table;
    private final CommandRegistry commandRegistry;
    private Card selectedCard;
    private Slot selectedSlot;
    private final CardImageService cardImageService;

    @FXML
    private ImageView selectedCardView;

    @FXML
    private Button undoButton;

    @FXML
    private Button redoButton;

    @FXML
    private ListView<Command> logView;

    @FXML
    private DeckSlotController deckView1Controller;

    @FXML
    private DeckSlotController deckView2Controller;

    @FXML
    private StackSlotController stackView1Controller;

    @FXML
    private StackSlotController stackView2Controller;

    @Autowired
    public TableController(Table table, CommandRegistry commandRegistry, CardImageService cardImageService) {
        this.table = table;
        this.commandRegistry = commandRegistry;
        this.cardImageService = cardImageService;
    }

    @FXML
    public void initialize() {
        logView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Command item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getName());
                }
            }
        });

        selectedCardView.setPreserveRatio(true);
        selectedCardView.setFitHeight(100);
        setModel();
    }

    public void setModel() {
        logView.setItems(commandRegistry.getCommandStack());
        deckView1Controller.setModel(table.getDecks().get(0), this);
        deckView2Controller.setModel(table.getDecks().get(1), this);
        stackView1Controller.setModel(table.getSlots().get(0), this, table.getSlots().get(0).isFullShown());
        stackView2Controller.setModel(table.getSlots().get(1), this, table.getSlots().get(1).isFullShown());
    }

    public void makeMove(StackSlot slot) {
        commandRegistry.executeCommand(new MoveCommand(table, selectedSlot, slot));
        selectedCard = null;
        selectedCardView.setOpacity(0);
    }

    public void undoButtonClicked(javafx.event.ActionEvent actionEvent) {
        selectedCard = null;
        selectedCardView.setOpacity(0);
        commandRegistry.undo();
    }

    public void redoButtonClicked(javafx.event.ActionEvent actionEvent) {
        selectedCard = null;
        selectedCardView.setOpacity(0);
        commandRegistry.redo();
    }

    public void handleCancelClick(MouseEvent mouseEvent) {
        if(mouseEvent.getButton().toString().equals("SECONDARY")) {
            if(selectedCard != null) {
                selectedCard = null;
                selectedCardView.setOpacity(0);
            }
        }
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card card) {
        selectedCard = card;
        selectedCardView.imageProperty().set(cardImageService.getImage(selectedCard));
        selectedCardView.setOpacity(1);
    }

    public Slot getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(Slot slot) {
        selectedSlot = slot;
    }
}