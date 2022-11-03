package baseball.domain.factory;

import baseball.domain.Balls;
import baseball.domain.strategy.BallsCreateStrategy;
import baseball.domain.strategy.RandomBallsCreateStrategy;

public class ComputerBallsFactory {
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 유틸 클래스입니다.";
    
    private ComputerBallsFactory() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }
    
    public static Balls createComputerBalls(final BallsCreateStrategy ballsCreateStrategy) {
        return new Balls(ballsCreateStrategy.create());
    }
}
