package baseball.controller;

import baseball.message.GameProgressMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.message.GameProgressMessage.*;
import static baseball.message.ResultMessage.*;
import static baseball.util.GameCode.*;
import static baseball.util.RegexCode.*;

public class BullsAndCows {

    private final List<Integer> answerNumberList = new ArrayList<>();
    private List<Integer> userInput;
    private int strikeCount = 0;
    private int ballCount = 0;

    public BullsAndCows() {
        createAnswerNumber();
    }

    public void playGame() {

        while (!isEnd()) {
            System.out.println(PROGRESS_MESSAGE);
            String userInput = Console.readLine();
            System.out.println(getResultMessageOfGuessNumber(userInput));
        }

        String userInput = Console.readLine();
        GameProgressMessage resultOfEndGame = getResultOfEndGame(userInput);

        System.out.println(ASK_QUIT);

        if (resultOfEndGame.equals(RESTART)) {
            System.out.println(RESTART);
            restart();
        }

        if (resultOfEndGame.equals(END)) {
            System.out.println(END);
        }
    }

    private boolean isEnd() {
        return strikeCount == STRIKE_COUNT_FOR_END.getCode();
    }

    private void restart() {
        createAnswerNumber();
        playGame();
    }

    private void createAnswerNumber() {
        initCountValues();
        answerNumberList.clear();
        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }

        validateNumber(answerNumberList);
    }

    private void initCountValues() {
        strikeCount = 0;
        ballCount = 0;
    }

    private GameProgressMessage getResultOfEndGame(String userInput) {
        int flag = Integer.parseInt(userInput);

        if (flag == (RESTART_GAME.getCode())) {
            return RESTART;
        }

        if (flag == END_GAME.getCode()) {
            return END;
        }

        throw new IllegalArgumentException("Game is over, you must input only flag number");
    }

    private String getResultMessageOfGuessNumber(String userInput) {
        validateNumber(userInput);

        this.userInput = Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (isNothing()) {
            return NOTHING.getMessage();
        }

        return getResultScore();
    }

    private boolean isNothing() {
        return userInput.stream()
                .noneMatch(answerNumberList::contains);
    }

    private String getResultScore() {
        return (getBallScore() + " " + getStrikeScore()).trim();
    }

    private String getStrikeScore() {
        strikeCount = 0;

        IntStream.range(0, userInput.size())
                .filter(this::isStrikeByIndex)
                .forEach(index -> strikeCount++);

        return STRIKE.of(strikeCount);
    }

    private boolean isStrikeByIndex(int index) {
        return Objects.equals(answerNumberList.get(index), userInput.get(index));
    }

    private String getBallScore() {
        ballCount = 0;

        IntStream.range(0, userInput.size())
                .filter(this::isBallByIndex)
                .forEach(index -> ballCount++);

        return BALL.of(ballCount);
    }

    private boolean isBallByIndex(int index) {
        return !isStrikeByIndex(index) && answerNumberList.contains(userInput.get(index));
    }

    private void validateNumber(List<Integer> input) {
        StringBuilder builder = new StringBuilder();
        input.forEach(builder::append);
        String result = builder.toString();

        validateIsNumber(result);
        validateLength(result);
        validateDuplicate(result);
    }

    private void validateNumber(String input) {
        validateIsNumber(input);
        validateLength(input);
        validateDuplicate(input);
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH.getCode()) {
            throw new IllegalArgumentException("number length must be 3");
        }
    }

    private void validateIsNumber(String input) {
        if (input.matches(REGEX_NOT_NUMBER.getRegex())) {
            throw new IllegalArgumentException("input value must be number");
        }
    }

    private void validateDuplicate(String input) {
        Pattern pattern = Pattern.compile(REGEX_HAS_DUPLICATE_VALUE.getRegex());
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException("number must not be duplicated");
        }
    }
}
