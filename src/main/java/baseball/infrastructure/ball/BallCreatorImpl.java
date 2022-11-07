package baseball.infrastructure.ball;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.ball.service.BallCreator;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BallCreatorImpl implements BallCreator {

    @Override
    public Balls createBalls(List<Integer> numberList) {
        final AtomicInteger index = new AtomicInteger();

        return Balls.of(numberList.stream()
                .map(number -> Ball.create(number, index.getAndIncrement()))
                .collect(Collectors.toUnmodifiableList()));
    }
}
