package pl.edu.agh.to2.cardgame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.to2.cardgame.model.Table;
import pl.edu.agh.to2.cardgame.model.cardSet.CardSetFactory;
import pl.edu.agh.to2.cardgame.model.slot.DeckSlot;
import pl.edu.agh.to2.cardgame.model.slot.StackSlot;

@Configuration
public class AppConfig {

    @Autowired
    CardSetFactory factory;

    @Bean
    public Table table(){
        return new Table(stackSlots(), deckSlots());
    }

    @Bean("imageUrlFormat")
    public String imageUrlFormat() {
        return "/images/%s_of_%s.png";
    }

    @Bean("reverseUrl")
    public String reverseUrl() {
        return "/images/reverse.png";
    }

    public ObservableList<StackSlot> stackSlots() {
        ObservableList<StackSlot> stackSlots = FXCollections.observableArrayList();
        stackSlots.add(new StackSlot(0, factory.createStack(true)));
        stackSlots.add(new StackSlot(1, factory.createStack(false)));

        return stackSlots;
    }

    public ObservableList<DeckSlot> deckSlots() {
        ObservableList<DeckSlot> deckSlots = FXCollections.observableArrayList();
        deckSlots.add(new DeckSlot(0, factory.createDeck()));
        deckSlots.add(new DeckSlot(1, factory.createDeck()));
        deckSlots.get(0).getCardSet().shuffle();
        deckSlots.get(1).getCardSet().shuffle();

        return deckSlots;
    }
}
