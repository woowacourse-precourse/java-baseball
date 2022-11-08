package baseball.domain;

import baseball.exception.NumberValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public final class Player {

    private Balls balls;

    public void setInputBalls() {
        String number = Console.readLine();
        balls = Balls.valueOf(number);
    }

    public String getRestartResponse() {
        String command = Console.readLine();
        NumberValidator.isValidCommandDigit(command);
        return command;
    }

    public List<Integer> getBalls() {
        return balls.asList();
    }
}
