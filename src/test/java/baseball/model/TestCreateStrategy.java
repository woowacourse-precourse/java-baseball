package baseball.model;

import java.util.List;

public class TestCreateStrategy implements BallNumbersCreateStrategy {
    @Override
    public List<Character> createBallNumbers() {
        return List.of('1', '2', '3');
    }
}
