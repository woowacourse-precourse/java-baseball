package baseball.service;

import baseball.model.Ball;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Validator.*;

public class PlayerService {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public List<Ball> generatePlayerBalls() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerInput = Console.readLine();

        validateInputLength(playerInput);
        validateParseStringToInt(playerInput);

        return convertInputToBallList(playerInput);
    }

    private List<Ball> convertInputToBallList(String playerInput) {
        String[] inputSplits = playerInput.split("");

        List<Ball> playerBalls = new ArrayList<>();
        for (String inputSplit : inputSplits) {
            Ball ball = new Ball(Integer.parseInt(inputSplit));
            validateDuplication(playerBalls, ball);
            validateBallNumberRange(ball);
            playerBalls.add(ball);
        }
        return playerBalls;
    }
}