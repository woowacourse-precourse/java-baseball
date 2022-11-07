package baseball.domain.baseball;

import baseball.util.InputChecker;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BaseBallGamePlayer {
    private final long ballCount;
    private final long strikeCount;
    private final List<Integer> userInput;
    private final Ball ball;

    public BaseBallGamePlayer(Ball ball) {
        this.ball = ball;
        this.userInput = userInput();
        ballCount = countBall();
        strikeCount = countStrike();
    }

    List<Integer> userInput() {
        String input = Console.readLine();
        InputChecker.isValid(input);
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public long getBallCount() {
        return ballCount;
    }

    public List<Integer> getUserInput() {
        return userInput;
    }

    public long getStrikeCount() {
        return strikeCount;
    }

    long countBall() {
        return userInput.stream()
                .filter(ball::isContains)
                .filter(this::isBall)
                .count();
    }

    long countStrike() {
        return userInput.stream()
                .filter(this::isStrike)
                .count();
    }

    boolean isStrike(int number) {
        return userInput.indexOf(number) == ball.getIndex(number);
    }

    boolean isBall(int number) {
        return userInput.indexOf(number) != ball.getIndex(number);
    }
}
