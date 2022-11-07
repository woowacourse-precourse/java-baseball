package baseball;

import baseball.validation.UserValidator;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void printStrikeAndBall(int strike, int ball) {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    public boolean isCorrectAllNumber(int strike) {
        return strike == 3;
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
