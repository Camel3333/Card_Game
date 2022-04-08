package pl.edu.agh.to2.cardgame;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardGameApplicationSpring {

    public static void main(String[] args) {
        Application.launch(CardGameApplicationJavaFX.class, args);
    }

}
