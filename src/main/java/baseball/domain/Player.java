package baseball.domain;

import baseball.exception.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public final class Player {

    private final Balls balls;

    private Player(Balls balls) {
        this.balls = balls;
    }

    public static Player create() {
        String number = Console.readLine();
        return new Player(Balls.valueOf(number));
    }

    public List<Integer> getBalls() {
        return balls.asList();
    }
}
