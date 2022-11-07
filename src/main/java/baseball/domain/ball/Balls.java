package baseball.domain.ball;

import baseball.domain.result.PlayResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {

    private static final int BALLS_RULE_SIZE = 3;
    private final List<Ball> balls;

    private Balls(List<Integer> numbers) {
        validate(numbers);
        this.balls = new ArrayList<>();
        mapToBalls(numbers);
    }

    public static Balls of(List<Integer> balls) {
        return new Balls(balls);
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != BALLS_RULE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void mapToBalls(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            balls.add(Ball.of(numbers.get(i), i + 1));
        }
    }

    public PlayResult play(Balls target) {
        PlayResult playResult = new PlayResult();
        balls.forEach(balls -> {
            target.balls.stream().map(balls::play).forEach(playResult::save);
        });
        return playResult;
    }
}