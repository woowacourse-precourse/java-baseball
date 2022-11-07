package baseball.domain;


import static baseball.global.constants.Constants.*;
import static baseball.global.exception.CustomException.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.global.constants.Constants.Korean;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private Computer computer;
    private Score score;

    private BaseballGame() {
    }

    public void init() {
        computer.init();
        score.init();
    }

    public void play() {
        List<Integer> userNumbers;
        while (score.getStrikeCount() < THREE_DIGITS) {
            System.out.println(Korean.PLEASE_ENTER_NUMBER);
            final String userInput = readLine();

            validateUserInputType(userInput);
            userNumbers = toList(userInput);
            validateUserNumbers(userNumbers);
        }
    }

    // === 테스트 메서드 ===
    public void test(String userInput) {
        List<Integer> userNumbers;
        while (score.getStrikeCount() < THREE_DIGITS) {
            System.out.println(Korean.PLEASE_ENTER_NUMBER);

            validateUserInputType(userInput);
            userNumbers = toList(userInput);
            validateUserNumbers(userNumbers);
        }
    }

    private List<Integer> toList(String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateUserInputType(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DATA_TYPE.getMessage());
        }
    }

    private void validateUserNumbers(List<Integer> userNumbers) {
        validateThreeDigit(userNumbers);
        validateDuplication(userNumbers);
        validateRange(userNumbers);
    }

    private void validateThreeDigit(List<Integer> userNumbers) {
        if (userNumbers.size() != THREE_DIGITS) {
            throw new IllegalArgumentException(INVALID_THREE_DIGIT.getMessage());
        }
    }

    private void validateDuplication(List<Integer> userNumbers) {
        long distinctCount = userNumbers.stream()
                .distinct()
                .count();
        if (distinctCount != userNumbers.size()) {
            throw new IllegalArgumentException(INVALID_THREE_DIGIT.getMessage());
        }
    }

    private void validateRange(List<Integer> userNumbers) {
        for (Integer userNumber : userNumbers) {
            if (userNumber < MIN_NUMBER || userNumber > MAX_NUMBER) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BaseballGame baseballGame = new BaseballGame();

        public Builder computer(Computer computer) {
            baseballGame.computer = computer;
            return this;
        }

        public Builder score(Score score) {
            baseballGame.score = score;
            return this;
        }

        public BaseballGame build() {
            return baseballGame;
        }
    }
}
