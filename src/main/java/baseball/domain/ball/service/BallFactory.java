package baseball.domain.ball.service;

import java.util.List;

public interface BallFactory {
    List<Integer> getRandomNumbers();

    List<Integer> convertStringToIntegerList(String number);
}
