package baseball.Players;

import baseball.Utils.Input;
import baseball.Utils.Validator;

public class UserChoice {

    private final String resetOrQuit;

    public UserChoice() {
        String input = Input.getResetOrQuit();
        this.resetOrQuit = createResetOrQuit(input);
    }

    public String getResetOrQuit() {
        return resetOrQuit;
    }

    private String createResetOrQuit(String input) {
        validate(input);
        return input;
    }

    private void validate(String input) {
        Validator validator = new Validator(input);
        validator.isOneOrTwo();
    }
}
