package baseball.engine;

import baseball.model.BallStatus;
import baseball.model.Numbers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DefaultBaseBallGameEngine implements BaseBallGameEngine {
    private final static int NUMBERS_SIZE = 3;

    @Override
    public BallStatus countBall(Numbers answer, Numbers userNumbers) {
        AtomicInteger ball = new AtomicInteger();
        AtomicInteger strike = new AtomicInteger();

        userNumbers.iterateForEach((i, n) -> {
            if (!answer.containAnswer(n)) {
                return;
            }

            if (answer.matchStrike(i, n)) {
                strike.getAndIncrement();
                return;
            }

            ball.getAndIncrement();
        });

        return new BallStatus(ball.get(), strike.get());
    }

    @Override
    public Numbers parseToNumbers(String number) {
        if (number == null || isNotValidNumber(number)) {
            throw new IllegalArgumentException();
        }

        return new Numbers(number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList())
        );
    }

    private boolean isNotValidNumber(String stringNumber) {
        if (stringNumber.length() != NUMBERS_SIZE) {
            return true;
        }

        long count = stringNumber.chars()
                .filter(Character::isDigit)
                .count();

        return count != NUMBERS_SIZE;
    }
}
