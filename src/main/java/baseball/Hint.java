package baseball;

import java.util.ArrayList;
import java.util.List;

public class Hint {

    int ball = 0;
    int strike = 0;

    public boolean gameEnd(List<Integer> computerNumber, List<Integer> userNumber) {

        countBallAndStrike(computerNumber, userNumber);

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        else if (strike == 0) {
            System.out.println(ball + "볼");
        }
        else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return true;
    }

    public void countBallAndStrike(List<Integer> computerNumber, List<Integer> userNumber) {

        for (int i = 0; i < 3; i++) {
            int oneComputerNumber = computerNumber.get(i);
            int oneUserNumber = userNumber.get(i);

            if (oneComputerNumber == oneUserNumber) {
                strike += 1;
            }
            else if (computerNumber.contains(oneUserNumber)) {
                ball += 1;
            }
        }
    }
}
