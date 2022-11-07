package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player {

    public static final String NUMBER_SIZE_EX_MESSAGE = "입력값은 3개의 숫자여야 합니다.";
    public static final int GAME_ROUND = 3;
    public static final String NUMBER_DUPLICATE_EX_MESSAGE = "입력값은 같은 수가 하나라도 있으면 안됩니다.";
    public static final int START_POSITION_NUMBER = 1;
    public static final String BALL_SIZE_ZERO_EX_MESSAGE = "볼을 넣어야 플레이가 가능합니다.";
    public static final int CRITERION_ZERO = 0;

    private final List<Ball> balls;

    public Player() {
        balls = new ArrayList<>();
    }

    public Player(List<Integer> numbers) {
        validate(numbers);
        balls = mapToBalls(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GAME_ROUND) {
            throw new IllegalArgumentException(NUMBER_SIZE_EX_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicateNumbers = new HashSet<>(numbers);
        if (checkDuplicateNumbers.size() != GAME_ROUND) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_EX_MESSAGE);
        }
    }

    private List<Ball> mapToBalls(List<Integer> numbers) {
        AtomicInteger position = new AtomicInteger(START_POSITION_NUMBER);
        return numbers.stream()
                .map(number -> new Ball(position.getAndIncrement(), number))
                .collect(Collectors.toList());
    }

    public Referee playGame(Player otherPlayer) {
        validateBallSize(otherPlayer);
        Referee referee = new Referee();
        for (Ball ball : balls) {
            BallMatchResult ballMatchResult = otherPlayer.playRound(ball);
            referee.addScore(ballMatchResult);
        }
        return referee;
    }

    private void validateBallSize(Player otherPlayer) {
        if (this.isBallSizeZero() || otherPlayer.isBallSizeZero()) {
            throw new IllegalStateException(BALL_SIZE_ZERO_EX_MESSAGE);
        }
    }

    private boolean isBallSizeZero() {
        return balls.size() == CRITERION_ZERO;
    }

    private BallMatchResult playRound(Ball otherBall) {
        return balls.stream()
                .map(ball -> ball.match(otherBall))
                .filter(ballMatchResult -> !ballMatchResult.isNothing())
                .findFirst()
                .orElse(BallMatchResult.NOTHING);
    }

    public void changeBalls(List<Integer> newBallNumbers) {
        validate(newBallNumbers);
        balls.clear();
        balls.addAll(mapToBalls(newBallNumbers));
    }
}