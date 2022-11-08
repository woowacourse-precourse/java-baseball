package baseball.facade;

import baseball.domain.Referee;
import baseball.exception.IllegalInputException;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RefereeFacade {

    public void countScore(List<Integer> computer, List<Integer> user, Referee referee) {

        for (int i = 0; i < referee.INPUT_SIZE; i++) {

            int expected = computer.get(i);
            int actual = user.get(i);

            if (expected == actual) {
                referee.strike++;
            }

            if (computer.contains(actual)) {
                referee.ball++;
            }
        }

        referee.ball -= referee.strike;
    }

    public boolean judgeResult(int strike) {

        if (strike == 3) {

            View.victory();
            View.restartGame();

            int input = Integer.parseInt(Console.readLine());

            if (input == 1) {
                return true;
            }
            else if (input == 2) {
                return false;
            }
            else {
                throw IllegalInputException.EXCEPTION;
            }
        }

        return true;
    }

    public  void answerResult(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        else if (ball > 0) {
            System.out.println(ball + "볼");
        }
        else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println("낫싱");
        }
    }
}
