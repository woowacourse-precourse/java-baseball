package baseball.domain;

import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls of(List<Ball> balls) {
        return new Balls(balls);
    }

    public int size() {
        return balls.size();
    }

    public PlayResult play(Balls target) {
        PlayResult playResult = new PlayResult();
        balls.forEach(balls -> {
            target.balls.stream().map(balls::play).forEach(playResult::save);
        });
        return playResult;
    }
}