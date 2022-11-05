package baseball.service;

import baseball.Ball;
import baseball.utils.MessagePrinter;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Validator.*;

public class PlayerService {
    public List<Ball> generatePlayerBalls() {
        MessagePrinter.showInputNumber();
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
            playerBalls.add(ball);
        }
        return playerBalls;
    }
}