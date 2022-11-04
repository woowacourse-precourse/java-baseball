package baseball.domain;

import baseball.infrastructure.util.ConsoleInStringImpl;
import baseball.infrastructure.util.GamerInputNumberGenerator;
import java.util.List;

public class Gamer {

    private Balls gamerBalls;

    private Gamer(List<Integer> balls) {
        gamerBalls.from(balls);
    }

    public static Gamer from(ConsoleInString consoleInString) {
        return new Gamer(GamerInputNumberGenerator.generator(consoleInString));
    }
}
