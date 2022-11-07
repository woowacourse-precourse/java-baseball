package baseball;

import baseball.ball.Ball;
import baseball.ball.Balls;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private Balls playerBalls;

    public Player() {
        playerBalls = new Balls();
    }

    private List<Ball> createBallByInput(List<String> playNumber) {
        return playNumber.stream()
                .map(ballNumber -> new Ball(Integer.parseInt(ballNumber)))
                .collect(Collectors.toList());
    }

    private List<String> inputPlayerNumber() {
        OutputView.requestInputNumber();
        String playerCandidateNumber = InputView.inputPlayerNumber();
        return Arrays.asList(playerCandidateNumber.split(""));
    }
}
