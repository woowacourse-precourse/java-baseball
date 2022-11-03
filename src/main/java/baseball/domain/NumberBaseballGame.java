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

    private List<NumberBall> getUserNumberBall() throws IllegalArgumentException {
        String userInput = getUserInputString();
        validate(userInput);
        return Stream.of(userInput.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(NumberBall::new)
                .collect(Collectors.toList());
    }

    private String getUserInputString() {
        return Console.readLine();
    }

    private void validate(String userInput) {
        if (!supportsInputLength(userInput)) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }

        if (!supportsNumberRange(userInput)) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_RANGE);
        }

        if (includesDuplicateNumber(userInput)) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }
    }

    private boolean includesDuplicateNumber(String userInput) {
        int userInputLength = (int) Stream.of(userInput.split("")).distinct().count();
        if (userInputLength != 3) {
            return true;
        }
        return false;
    }

    private boolean supportsNumberRange(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) < '1' || userInput.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private boolean supportsInputLength(String userInput) {
        return userInput.length() == 3;
    }

    private List<NumberBall> initializeSystemNumberBall() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return numbers.stream().map(NumberBall::new).collect(Collectors.toList());
    }
}