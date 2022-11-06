package baseball.model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Validator.validateParseStringToInt;

public class Player {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public Balls generatePlayerBalls() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerInput = Console.readLine();

        validateParseStringToInt(playerInput);
        return new Balls(convertInputToBallList(playerInput));
    }

    private List<Integer> convertInputToBallList(String playerInput) {
        String[] inputSplits = playerInput.split("");

        List<Integer> playerBalls = new ArrayList<>();
        for (String inputSplit : inputSplits) {
            playerBalls.add(Integer.parseInt(inputSplit));
        }
        return playerBalls;
    }
}