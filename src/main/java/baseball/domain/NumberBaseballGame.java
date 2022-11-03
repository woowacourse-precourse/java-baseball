package baseball.domain;

import baseball.util.GameExceptionMessage;
import baseball.util.ShowGameMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberBaseballGame {
    private final ShowGameMessage showGameMessage = new ShowGameMessage();
    private ScoreBoard scoreBoard;

    private void init() {
        scoreBoard = new ScoreBoard(initializeSystemNumberBall());
        showGameMessage.gameStartMessage();
    }

    private List<NumberBall> getUserNumberBall() {
        String userInput = getUserInputString();
        validate(userInput);
    }
    private String getUserInputString() {
        return Console.readLine();
    }

    private void validate(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) >= '1' && userInput.charAt(i) <= '9') {
                continue;
            }
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_RANGE);
        }
        int len = (int) Stream.of(userInput.split("")).distinct().count();
        if (len != 3) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }
    }

    private List<NumberBall> initializeSystemNumberBall() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return numbers.stream().map(NumberBall::new).collect(Collectors.toList());
    }
}