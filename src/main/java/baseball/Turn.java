package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Turn {
    private static final int NUMBER_OF_INPUT_DIGITS = 3;
    private static final int STRIKE_OUT_NUMBER = 3;
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String ASK_FOR_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String SIZE_NOT_THREE_EXCEPTION_MESSAGE = "3개의 숫자를 입력해주세요.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "1에서 9까지의 숫자를 입력해 주세요.";
    private static final String DUPLICATE_NUMBERS_EXCEPTION_MESSAGE = "서로 다른 숫자를 입력해주세요.";

    private List<Integer> playerNumberList;
    private int numberOfBalls;
    private int numberOfStrikes;

    public Turn() {
    }

    public void start(List<Integer> hiddenNumberList) {
        String playerInput = getPlayerInput(ASK_FOR_NUMBER_MESSAGE);
        this.playerNumberList = transformPlayerInputToList(playerInput);
        validatePlayerNumberList(this.playerNumberList);
        this.numberOfBalls = countNumberOfBalls(this.playerNumberList, hiddenNumberList);
        this.numberOfStrikes = countNumberOfStrikes(this.playerNumberList, hiddenNumberList);
        printResult(this.numberOfBalls, this.numberOfStrikes);
    }

    public String getPlayerInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }

    public List<Integer> transformPlayerInputToList(String playerInput) {
        List<Integer> playerNumberList = new ArrayList<>();
        for (int index = 0; index < playerInput.length(); index++) {
            int inputInInteger = transformCharacterToInteger(playerInput.charAt(index));
            playerNumberList.add(inputInInteger);
        }
        return playerNumberList;
    }

    public int transformCharacterToInteger(char character){
        return character - '0';
    }

    public void validatePlayerNumberList(List<Integer> playerNumberList) {
        if (playerNumberList.size() != NUMBER_OF_INPUT_DIGITS) {
            throw new IllegalArgumentException(SIZE_NOT_THREE_EXCEPTION_MESSAGE);
        }
        for (int number : playerNumberList) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        }
        Set<Integer> numberSet = new HashSet<>(playerNumberList);
        if (numberSet.size() < playerNumberList.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    public int countNumberOfBalls(List<Integer> playerNumberList, List<Integer> hiddenNumberList) {
        int numberOfBalls = 0;
        for (int index = 0; index < NUMBER_OF_INPUT_DIGITS; index++) {
            int hiddenNumber = hiddenNumberList.get(index);
            int playerNumber = playerNumberList.get(index);
            if (hiddenNumberList.contains(playerNumber) && hiddenNumber != playerNumber) {
                numberOfBalls++;
            }
        }
        return numberOfBalls;
    }

    public int countNumberOfStrikes(List<Integer> playerNumberList, List<Integer> hiddenNumberList) {
        int numberOfStrikes = 0;
        for (int index = 0; index < NUMBER_OF_INPUT_DIGITS; index++) {
            int hiddenNumber = hiddenNumberList.get(index);
            int playerNumber = playerNumberList.get(index);
            if (hiddenNumber == playerNumber) {
                numberOfStrikes++;
            }
        }
        return numberOfStrikes;
    }

    public void printResult(int numberOfBalls, int numberOfStrikes) {
        StringBuilder result = new StringBuilder();
        String ballResult = getBallResultString(numberOfBalls);
        String strikeResult = getStrikeResultString(numberOfStrikes);
        result.append(ballResult);
        if (!ballResult.isEmpty() && !strikeResult.isEmpty()) {
            result.append(' ');
        }
        result.append(strikeResult);
        if (ballResult.isEmpty() && strikeResult.isEmpty()) {
            result.append(NOTHING_MESSAGE);
        }
        System.out.println(result);
    }

    public String getBallResultString(int numberOfBalls) {
        return getResultString(numberOfBalls, BALL_MESSAGE);
    }

    public String getStrikeResultString(int numberOfStrikes) {
        return getResultString(numberOfStrikes, STRIKE_MESSAGE);
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

    public void printGameOverMessage() {
        System.out.println(GAME_OVER_MESSAGE);
    }
}
