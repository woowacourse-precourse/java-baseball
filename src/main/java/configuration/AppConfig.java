입package configuration;

import extract.Validation;
import features.Game;
import features.Hint;
import features.Input;
import features.Player;
import features.Print;
import java.util.Map;

public class AppConfig implements Factory {

    @Override
    public Map<Integer, Character> inputUserNumber() {
        return Input.inputUserNumber();
    }

    @Override
    public Map<Integer, Character> createComputerNumber() {
        return Player.createComputerNumber();
    }

    @Override
    public void loopHint(Map<Integer, Character> userNumber, Map<Integer, Character> computerNumber) {

        Hint.getCountStrike();
        Hint.getCountBall();
        Hint.getCountNothing();

    }

    @Override
    public String printResult() {
        return Print.printResult();
    }

    @Override
    public String playGame() {
        return Game.playGame();
    }

    @Override
    public boolean validationCheck(String userLine) {
        return Validation.validationCheck(userLine);
    }


}
