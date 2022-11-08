package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String EMPTY_SPLIT = "";
    private static final String INVALID_INPUT_TYPE_MESSAGE = "숫자만 입력이 가능합니다.";

    public Balls generatePlayerBalls(String inputValue) {
        return new Balls(convertInputToBallList(inputValue));
    }

    private List<Ball> convertInputToBallList(String playerInput) {
        validateParseStringToInteger(playerInput);
        String[] inputSplits = playerInput.split(EMPTY_SPLIT);

        List<Ball> playerValues = new ArrayList<>();
        for (String inputSplit : inputSplits) {
            int number = Integer.parseInt(inputSplit);
            playerValues.add(new Ball(number));
        }
        return playerValues;
    }

    private void validateParseStringToInteger(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE_MESSAGE);
        }
    }
}