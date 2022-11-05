package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.ResultMessage.*;

public class BullsAndCows {

    private static final int NUMBER_LENGTH = 3;
    private static final String REGEX_NOT_NUMBER = "^\\d";
    private static final int STRIKE_COUNT_FOR_END = 3;
    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;

    private final List<Integer> answerNumberList = new ArrayList<>();
    private List<Integer> userInput;
    private int strikeCount = 0;
    private int ballCount = 0;

    BullsAndCows() {
        createRandomAnswer();
    }

    public void playGame() {

        while (!isEnd()) {
            String userInput = Console.readLine();
            System.out.println(getResultMessageOfGuessNumber(userInput));
        }

        String userInput = Console.readLine();
        ResultMessage resultOfEndGame = getResultOfEndGame(userInput);

        System.out.println(GAME_END_MESSAGE);

        if (resultOfEndGame.equals(RESTART)) {
            System.out.println(RESTART.getMessage());
            restart();
        }

        if (resultOfEndGame.equals(END)) {
            System.out.println(END.getMessage());
        }

    }

    private String getResultMessageOfGuessNumber(String userInput) {
        validateIsNumber(userInput);
        validateLength(userInput);

        this.userInput = Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (isNothing()) {
            return NOTHING.getMessage();
        }

        return getResultScoreByFormat().trim();
    }

    private ResultMessage getResultOfEndGame(String userInput) {
        int flag = Integer.parseInt(userInput);
        if (flag == (RESTART_GAME)) {
            return RESTART;
        }

        if (flag == END_GAME) {
            return END;
        }

        throw new IllegalArgumentException("Game is over, you must input only flag number");
    }

    private void restart() {
        createRandomAnswer();
        playGame();
    }

    private void createRandomAnswer() {
        initCountValues();
        answerNumberList.clear();
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
    }

    private void initCountValues() {
        strikeCount = 0;
        ballCount = 0;
    }

    private String getResultScoreByFormat() {
        return getBallNumber() + " " + getStrikeNumber();
    }

    private String getStrikeNumber() {
        strikeCount = 0;

        IntStream.range(0, userInput.size())
                .filter(this::isStrike)
                .forEach(index -> strikeCount++);

        return STRIKE.of(strikeCount);
    }

    private boolean isStrike(int index) {
        return Objects.equals(answerNumberList.get(index), userInput.get(index));
    }

    private String getBallNumber() {
        ballCount = 0;

        IntStream.range(0, userInput.size())
                .filter(this::isBall)
                .forEach(index -> ballCount++);

        return BALL.of(ballCount);
    }

    private boolean isBall(int index) {
        return !isStrike(index) && answerNumberList.contains(userInput.get(index));
    }

    private boolean isNothing() {
        return userInput.stream()
                .noneMatch(answerNumberList::contains);
    }

    private boolean isEnd() {
        return strikeCount == STRIKE_COUNT_FOR_END;
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("number length must be 3");
        }
    }

    private void validateIsNumber(String input) {
        if (input.matches(REGEX_NOT_NUMBER)) {
            throw new IllegalArgumentException("input value must be number");
        }
    }
}
