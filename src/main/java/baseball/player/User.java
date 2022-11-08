package baseball.player;

import baseball.Message;
import baseball.Valid;
import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class User extends Player {

    @Override
    public void selectBalls() {
        Message.SELECT_BALLS.print();

        String userInput = Console.readLine();
        validUserInput(userInput);

        List<String> selectBalls = List.of(userInput.split(""));
        selectBalls.forEach(this::selectBall);
    }

    private void validUserInput(String userInput) {
        if (!isSelectRightNumber(userInput)) {
            throw new IllegalArgumentException();
        }

        if (hasNotInputNumber(userInput)) {
            throw new IllegalArgumentException();
        }

        if (hasDuplicateBall(userInput)) {
            throw new IllegalArgumentException();
        }
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
