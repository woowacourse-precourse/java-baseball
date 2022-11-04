package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Turn {
    private static final int NUMBER_OF_INPUT_DIGITS = 3;
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String ASK_FOR_NUMBER = "숫자를 입력해주세요 : ";
    private static final int STRIKE_OUT_NUMBER = 3;
    private List<Integer> playerNumberList;
    private int numberOfBalls;
    private int numberOfStrikes;

    public Turn() {
        this.playerNumberList = new ArrayList<>();
        numberOfBalls = 0;
        numberOfStrikes = 0;
    }

    public void transformPlayerInputToList() {
        String playerInput = getPlayerInput(ASK_FOR_NUMBER);
        for (int index = 0; index < playerInput.length(); index++) {
            playerNumberList.add(playerInput.charAt(index) - '0');
        }
    }

    public String getPlayerInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }

    public void validatePlayerNumberList() {
        if (playerNumberList.size() != NUMBER_OF_INPUT_DIGITS) {
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        }
        for (int number : playerNumberList) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException("1에서 9까지의 숫자만 입력해 주세요.");
            }
        }
        Set<Integer> numberSet = new HashSet<>(playerNumberList);
        if (numberSet.size() < playerNumberList.size()) {
            throw new IllegalArgumentException("서로 다른 숫자만 입력해주세요.");
        }
    }

    public void countNumberOfStrikes(List<Integer> hiddenNumberList) {
        for (int index = 0; index < NUMBER_OF_INPUT_DIGITS; index++) {
            int hiddenNumber = hiddenNumberList.get(index);
            int playerNumber = this.playerNumberList.get(index);
            if (hiddenNumber == playerNumber) {
                this.numberOfStrikes++;
            }
        }
    }

    public void countNumberOfBalls(List<Integer> hiddenNumberList) {
        for (int index = 0; index < NUMBER_OF_INPUT_DIGITS; index++) {
            int hiddenNumber = hiddenNumberList.get(index);
            int playerNumber = this.playerNumberList.get(index);
            if (hiddenNumberList.contains(playerNumber) && hiddenNumber != playerNumber) {
                this.numberOfBalls++;
            }
        }
    }

    public void printResult() {
        StringBuilder result = new StringBuilder();
        String ballResult = getBallResultString();
        String strikeResult = getStrikeResultString();
        result.append(ballResult);
        if (!ballResult.isEmpty() && !strikeResult.isEmpty()) {
            result.append(' ');
        }
        result.append(strikeResult);
        System.out.println(result);
    }

    public String getStrikeResultString() {
        return getResultString(this.numberOfStrikes, STRIKE_MESSAGE);
    }

    public String getBallResultString() {
        return getResultString(this.numberOfBalls, BALL_MESSAGE);
    }

    public String getResultString(int score, String scoreMessage) {
        StringBuilder result = new StringBuilder();
        if (score > 0) {
            result.append(score);
            result.append(scoreMessage);
        }
        return result.toString();
    }

    public boolean isStrikeOut() {
        return this.numberOfStrikes == STRIKE_OUT_NUMBER;
    }
}
