package baseball.domain;

import java.util.List;

public class Gamer {

    private Balls gamerBalls;

    private Gamer(List<Integer> balls) {
        gamerBalls.from(balls);
    }

    public static Gamer from(List<Integer> balls) {
        return Gamer.from(balls);
    }
}
