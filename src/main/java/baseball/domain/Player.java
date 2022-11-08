package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public final class Player {

    private Balls balls;

    public void setInputBalls() {
        String number = Console.readLine();
        balls = Balls.valueOf(number);
    }

    public List<Integer> getBalls() {
        return balls.asList();
    }
}
