package baseball.player;

import baseball.Valid;
import java.util.Collections;
import java.util.List;
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

    private boolean hasDuplicateBall(String userInput) {
        List<String> selectBalls = List.of(userInput.split(""));

        for (String selectBall : selectBalls) {
            if (isDuplicateBall(selectBalls, selectBall)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateBall(List<String> selectBalls, String selectBall) {
        int frequency = Collections.frequency(selectBalls, selectBall);
        return frequency > 1;
    }
}
