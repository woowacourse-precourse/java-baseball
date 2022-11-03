package baseball.domain.strategy;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBallsCreateStrategy implements BallsCreateStrategy {
    private static final int MIN_NUMBER_OF_BALLS = 1;
    private static final int MAX_NUMBER_OF_BALLS = 9;
    private static final int COUNT_OF_BALLS = 3;
    
    @Override
    public List<Ball> create() {
        final List<Integer> ballNumbers = createRandomBallNumbers();
        
        return IntStream.range(0, COUNT_OF_BALLS)
                .mapToObj(position -> new Ball(position, ballNumbers.get(position)))
                .collect(Collectors.toList());
    }
    
    private static List<Integer> createRandomBallNumbers() {
        return IntStream.range(0, COUNT_OF_BALLS)
                .map(count -> Randoms.pickNumberInRange(MIN_NUMBER_OF_BALLS, MAX_NUMBER_OF_BALLS))
                .boxed()
                .collect(Collectors.toList());
    }
}
