package baseball.player;

import baseball.Valid;
import java.util.regex.Pattern;

public class User extends Player {

    @Override
    public void selectBalls() {

    }

    private boolean isSelectRightNumber(String userInput) {
        return userInput.length() == 3;
    }

    private boolean hasNotInputNumber(String userInput) {
        Pattern notInputNumberPattern = Valid.NOT_INPUT_NUMBER.getPattern();
        return notInputNumberPattern.matcher(userInput).find();
    }
}
