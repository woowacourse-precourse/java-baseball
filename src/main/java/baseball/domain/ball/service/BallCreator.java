package baseball.domain.ball.service;

import baseball.domain.ball.Balls;

import java.util.List;

public interface BallCreator {

    Balls createBalls(List<Integer> numberList);
}
