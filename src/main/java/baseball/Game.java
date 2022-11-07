package baseball;

import baseball.model.Ball;
import baseball.validation.UserValidator;
import camp.nextstep.edu.missionutils.Console;

public class Game {


    public boolean isCorrectAllNumber(Ball ball) {
        return ball.getStrike() == 3;
    }

    public int getRestart() {

        while (true) {
            String input = Console.readLine();

            if (UserValidator.restartValidation(input)) {
                return Integer.parseInt(input);
            }
        }
    }
}
