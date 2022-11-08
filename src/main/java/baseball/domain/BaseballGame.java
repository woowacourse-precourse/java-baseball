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
            System.out.print(Korean.PLEASE_ENTER_NUMBER_MESSAGE);
            final String userInput = readLine();

            validateUserInputType(userInput);
            userNumbers = toList(userInput);
            validateUserNumbers(userNumbers);

            int ballCount = computer.getBallCounts(userNumbers);
            int strikeCount = computer.getStrikeCounts(userNumbers);
            score.setScore(ballCount, strikeCount);

            printHintMessage();
        }
        printGameOverMessage();
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

    public void printHintMessage() {
        final int strikeCount = score.getStrikeCount();
        final int ballCount = score.getBallCount();

        final String hintMessage = getHintMessage(strikeCount, ballCount);
        System.out.println(hintMessage);
    }

    private String getHintMessage(int strikeCount, int ballCount) {
        final StringBuilder stringBuilder = new StringBuilder();

        if (strikeCount == 0 && ballCount == 0) {
            return Korean.NOTHING_MESSAGE;
        }
        if (ballCount != 0) {
            stringBuilder.append(ballCount)
                    .append(Korean.BALL_MESSAGE);
        }
        if (strikeCount != 0) {
            stringBuilder.append(strikeCount)
                    .append(Korean.STRIKE_MESSAGE);
        }

        return stringBuilder.toString();
    }

    public void printGameOverMessage() {
        System.out.println(Korean.GAME_OVER_MESSAGE);
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

    // === 테스트 메서드 ===
    public void test(String userInput) {
        List<Integer> userNumbers;
        while (score.getStrikeCount() < THREE_DIGITS) {
            System.out.println(Korean.PLEASE_ENTER_NUMBER_MESSAGE);

            validateUserInputType(userInput);
            userNumbers = toList(userInput);
            validateUserNumbers(userNumbers);
            break;
        }
    }
}
