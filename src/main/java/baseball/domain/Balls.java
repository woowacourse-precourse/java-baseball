package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 2;
    private static final int MAX_COUNT_OF_EACH_NUMBER = 1;
    
    private final List<Ball> balls;
    
    public Balls(final String numbers) {
        this(parseBalls(numbers));
    }
    
    public Balls(final List<Ball> balls) {
        this.balls = balls;
    }
    
    private static List<Ball> parseBalls(final String numbers) {
        return IntStream.rangeClosed(MIN_POSITION, MAX_POSITION)
                .mapToObj(position -> new Ball(position, numbers.substring(position, position + MAX_COUNT_OF_EACH_NUMBER)))
                .collect(Collectors.toList());
    }
    
    public BallStatus compareOneBallInOrder(final Ball ball) {
        return balls.stream()
                .map(userBall -> userBall.compareOneBall(ball))
                .filter(userBall -> userBall != BallStatus.NOTHING)
                .findAny()
                .orElse(BallStatus.NOTHING);
    }
}
