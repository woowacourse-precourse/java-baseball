package baseball.domain.strategy;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBallsCreateStrategy implements BallsCreateStrategy {
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "1~9의 범위를 벗어났습니다.";
    private static final int MIN_NUMBER_OF_BALLS = 1;
    private static final int MAX_NUMBER_OF_BALLS = 9;
    private static final int COUNT_OF_BALLS = 3;
    
    @Override
    public List<Ball> create() {
        final List<Integer> ballNumbers = createCorrectRandomBallNumbers();
        
        return IntStream.range(0, COUNT_OF_BALLS)
                .mapToObj(position -> new Ball(position, ballNumbers.get(position)))
                .collect(Collectors.toList());
    }
    
    private static List<Integer> createCorrectRandomBallNumbers() {
        try {
            final List<Integer> randomBallNumbers = createRandomBallNumbers();
            isValid(randomBallNumbers);
            return randomBallNumbers;
        } catch (IllegalArgumentException e) {
            return createCorrectRandomBallNumbers();
        }
    }
    
    private static List<Integer> createRandomBallNumbers() {
        return IntStream.range(0, COUNT_OF_BALLS)
                .map(count -> Randoms.pickNumberInRange(MIN_NUMBER_OF_BALLS, MAX_NUMBER_OF_BALLS))
                .boxed()
                .collect(Collectors.toList());
    }
    
    private static void isValid(final List<Integer> randomBallNumbers) {
        validateOutOfRange(randomBallNumbers);
    }
    
    private static void validateOutOfRange(final List<Integer> randomBallNumbers) {
        if (existNumberOutOfRange(randomBallNumbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean existNumberOutOfRange(final List<Integer> randomBallNumbers) {
        return randomBallNumbers.stream()
                .anyMatch(RandomBallsCreateStrategy::isOutOfRange);
    }
    
    private static boolean isOutOfRange(final Integer randomBallNumber) {
        return randomBallNumber < MIN_NUMBER_OF_BALLS || randomBallNumber > MAX_NUMBER_OF_BALLS;
    }
}
