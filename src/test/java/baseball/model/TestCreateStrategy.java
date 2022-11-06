package baseball.model;

import java.util.List;

public class TestCreateStrategy implements BallNumbersCreateStrategy {
    @Override
    public List<Integer> createBallNumbers() {
        return List.of(1, 2, 3);
    }
}
