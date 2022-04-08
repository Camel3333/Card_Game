package pl.edu.agh.to2.cardgame.util;

import javafx.scene.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.agh.to2.cardgame.model.card.Card;
import pl.edu.agh.to2.cardgame.model.card.CardData;

@Component
public class CardImageService {

    private final String imageUrlFormat;
    private final String reverseUrl;

    @Autowired
    public CardImageService(@Qualifier("imageUrlFormat") String imageUrlFormat, @Qualifier("reverseUrl") String reverseUrl){
        this.imageUrlFormat = imageUrlFormat;
        this.reverseUrl = reverseUrl;
    }

    public Image getImage(Card card){
        return new Image(String.format(imageUrlFormat, card.getData().getRank().toString().toLowerCase(),
                card.getData().getSuit().toString().toLowerCase()));
    }

    public Image getReverse(){
        return new Image(reverseUrl);
    }
}
