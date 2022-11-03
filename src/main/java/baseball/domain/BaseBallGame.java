package baseball.domain;

import baseball.domain.factory.ComputerBallsFactory;
import baseball.domain.strategy.RandomBallsCreateStrategy;

public class BaseBallGame {
    private final Balls computerBalls;
    
    public BaseBallGame() {
        computerBalls = ComputerBallsFactory.createComputerBalls(new RandomBallsCreateStrategy());
    }
}
