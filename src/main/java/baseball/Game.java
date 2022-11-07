package baseball;

import baseball.validation.UserValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {


    public List<Integer> findStrikeAndBall(String user, List<Integer> computer) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            int num = user.charAt(i) - '0';

            int idx = computer.indexOf(num);

            if (idx == i) {
                strike++;
            } else if (idx != -1) {
                ball++;
            }
        }

        return List.of(strike, ball);
    }

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
