package baseball.domain.strategy;

import baseball.domain.Ball;

import java.util.List;

public interface BallsCreateStrategy {
    List<Ball> create();
}
