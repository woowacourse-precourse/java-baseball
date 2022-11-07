package baseball.domain.baseball;

import baseball.util.InputChecker;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BaseBallGamePlayer {
    private final long ballCount;
    private final long strikeCount;
    private final GameNumbers userNumbers;
    private final GameNumbers computerNumbers;

    public BaseBallGamePlayer(GameNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
        this.userNumbers = new GameNumbers(userInput());
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

    public GameNumbers getUserInput() {
        return userNumbers;
    }

    public long getStrikeCount() {
        return strikeCount;
    }

    long countBall() {
        return userNumbers.getNumberList().stream()
                .filter(computerNumbers::isContains)
                .filter(this::isBall)
                .count();
    }

    long countStrike() {
        return userNumbers.getNumberList().stream()
                .filter(this::isStrike)
                .count();
    }

    boolean isStrike(int number) {
        return userNumbers.getNumberList().indexOf(number) == computerNumbers.getIndex(number);
    }

    boolean isBall(int number) {
        return userNumbers.getNumberList().indexOf(number) != computerNumbers.getIndex(number);
    }
}
