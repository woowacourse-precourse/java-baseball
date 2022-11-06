package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INVALID_INPUT_TYPE_MESSAGE = "숫자를 입력해주세요.";

    public Balls generatePlayerBalls() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerInput = Console.readLine();

        return new Balls(convertInputToBallList(playerInput));
    }

    private List<Integer> convertInputToBallList(String playerInput) {
        validateParseStringToInt(playerInput);
        String[] inputSplits = playerInput.split("");

        List<Integer> playerBalls = new ArrayList<>();
        for (String inputSplit : inputSplits) {
            playerBalls.add(Integer.parseInt(inputSplit));
        }
        return playerBalls;
    }

    private void validateParseStringToInt(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE_MESSAGE);
        }
    }
}