package adaptech.biz;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == fields ==
    private final Game game;

    // == constructor ==
    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.debug("Inside init for class {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between "
                + game.getSmallest() +
                " and " + game.getBiggest();
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()) {
            return "You got it! The number was: " + game.getNumber();
        } else if(game.isGameLost()){
            return "You lost. The number was: " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid Number Range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        }else {
            String direction = "Lower";
            String pluralGuessAmount =  game.getRemainingGuesses() > 1 ? "es" : "";
            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " guess" + pluralGuessAmount + " left!";

        }
    }
}
