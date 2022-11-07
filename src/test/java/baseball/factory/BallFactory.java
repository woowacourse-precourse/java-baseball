package baseball.factory;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BallFactory {

    public static Balls balls(List<Integer> numberList) {
        final AtomicInteger index = new AtomicInteger();

        return Balls.of(numberList.stream()
                .map(number -> Ball.create(number, index.getAndIncrement()))
                .collect(Collectors.toUnmodifiableList()));
    }
}
