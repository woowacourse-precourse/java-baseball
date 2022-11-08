package baseball.domain;

import baseball.domain.factory.ComputerBallsFactory;
import baseball.domain.ballscreatestrategy.RandomBallsCreateStrategy;

import java.util.List;

public class BaseBallGame {
    private static final String NUMBERS_LENGTH_EXCEPTION_MESSAGE = "숫자 3개만 입력할 수 있습니다.";
    private static final int CORRECT_LENGTH_OF_NUMBERS = 3;
    
    private final Balls computerBalls;
    
    public BaseBallGame() {
        computerBalls = ComputerBallsFactory.createComputerBalls(new RandomBallsCreateStrategy());
    }
    
    public Referee play(final String userNumbers) {
        validateOutOfLength(userNumbers);
        return playResult(userNumbers);
    }
    
    private void validateOutOfLength(final String numbers) {
        if (isNotCorrectNumbersLength(numbers)) {
            throw new IllegalArgumentException(NUMBERS_LENGTH_EXCEPTION_MESSAGE);
        }
    }
    
    private boolean isNotCorrectNumbersLength(final String numbers) {
        return numbers.length() != CORRECT_LENGTH_OF_NUMBERS;
    }
    
    private Referee playResult(final String userNumbers) {
        final List<BallStatus> comparisonResult = compareBalls(userNumbers);
        final Referee referee = new Referee();
        referee.decide(comparisonResult);
        
        return referee;
    }
    
    private List<BallStatus> compareBalls(final String userNumbers) {
        return computerBalls.compareBalls(new Balls(userNumbers));
    }
    
    @Override
    public String toString() {
        return "BaseBallGame{" +
                "computerBalls=" + computerBalls +
                '}';
    }
}
