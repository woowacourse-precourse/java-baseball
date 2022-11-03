package baseball.domain.strategy;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBallsCreateStrategy implements BallsCreateStrategy {
    private static final String DUPLICATE_NUMBERS_EXCEPTION_MESSAGE = "같은 번호를 여러개 입력할 수 없습니다.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "1~9의 범위를 벗어났습니다.";
    private static final String OUT_OF_LENGTH_EXCEPTION_MESSAGE = "볼 개수는 3개여야 합니다.";
    private static final int MIN_NUMBER_OF_BALLS = 1;
    private static final int MAX_NUMBER_OF_BALLS = 9;
    private static final int COUNT_OF_BALLS = 3;
    private static final int MAX_COUNT_OF_EACH_NUMBER = 1;
    
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
        validateExistSameNumber(randomBallNumbers);
        validateOutOfLength(randomBallNumbers);
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
    
    private static void validateExistSameNumber(final List<Integer> randomBallNumbers) {
        if (existSameNumber(randomBallNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean existSameNumber(final List<Integer> randomBallNumbers) {
        return randomBallNumbers.stream()
                .anyMatch(randomBallNumber -> isExceedMaxCountOfEachNumber(randomBallNumbers, randomBallNumber));
    }
    
    private static boolean isExceedMaxCountOfEachNumber(final List<Integer> randomBallNumbers, final int randomBallNumber) {
        return countOfDuplicateNumber(randomBallNumbers, randomBallNumber) > MAX_COUNT_OF_EACH_NUMBER;
    }
    
    private static int countOfDuplicateNumber(final List<Integer> randomBallNumbers, final int targetRandomBallNumber) {
        return (int) randomBallNumbers.stream()
                .filter(randomBallNumber -> randomBallNumber == targetRandomBallNumber)
                .count();
    }
    
    private static void validateOutOfLength(final List<Integer> randomBallNumbers) {
        if (isNotCorrectNumbersLength(randomBallNumbers)) {
            throw new IllegalArgumentException(OUT_OF_LENGTH_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isNotCorrectNumbersLength(final List<Integer> randomBallNumbers) {
        return randomBallNumbers.size() != COUNT_OF_BALLS;
    }
}
