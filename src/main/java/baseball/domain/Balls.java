package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    private static final String DUPLICATE_NUMBERS_EXCEPTION_MESSAGE = "같은 번호를 여러개 입력할 수 없습니다.";
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 2;
    private static final int MAX_COUNT_OF_EACH_NUMBER = 1;
    
    private final List<Ball> balls;
    
    public Balls(final String numbers) {
        this(parseBalls(numbers));
    }
    
    public Balls(final List<Ball> balls) {
        validateExistSameNumber(balls);
        this.balls = balls;
    }
    
    private static List<Ball> parseBalls(final String numbers) {
        return IntStream.rangeClosed(MIN_POSITION, MAX_POSITION)
                .mapToObj(position -> new Ball(position, numbersSplit(numbers, position)))
                .collect(Collectors.toList());
    }
    
    private static String numbersSplit(final String numbers, final int position) {
        return numbers.substring(position, position + MAX_COUNT_OF_EACH_NUMBER);
    }
    
    private void validateExistSameNumber(final List<Ball> balls) {
        if (existSameNumber(balls)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXCEPTION_MESSAGE);
        }
    }
    
    private boolean existSameNumber(final List<Ball> balls) {
        return balls.stream()
                .anyMatch(ball -> isExceedMaxCountOfEachNumber(balls, ball));
    }
    
    private boolean isExceedMaxCountOfEachNumber(final List<Ball> balls, final Ball ball) {
        return countOfDuplicateNumber(ball, balls) > MAX_COUNT_OF_EACH_NUMBER;
    }
    
    private int countOfDuplicateNumber(final Ball targetBall, final List<Ball> balls) {
        return (int) balls.stream()
                .filter(ball -> ball.isSameNumber(targetBall))
                .count();
    }
    
    public List<BallStatus> compareBalls(final Balls userBalls) {
        return userBalls.balls.stream()
                .map(this::compareOneBallInOrder)
                .collect(Collectors.toList());
    }
    
    private BallStatus compareOneBallInOrder(final Ball userBall) {
        return balls.stream()
                .map(computerBall -> computerBall.compareOneBall(userBall))
                .filter(ballStatusResult -> ballStatusResult != BallStatus.NOTHING)
                .findAny()
                .orElse(BallStatus.NOTHING);
    }
    
    @Override
    public String toString() {
        return "Balls{" +
                "balls=" + balls +
                '}';
    }
}
