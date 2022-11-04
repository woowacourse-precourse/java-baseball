package baseball;

import java.util.List;

public class GameService {

    public Integer countStrike(List<Integer> randomNumber, List<Integer> userNumber){
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            if (randomNumber.get(index).equals(userNumber.get(index))) {
                strike += 1;
            }
        }
        return strike;
    }

    public Integer countBall(List<Integer> randomNumber, List<Integer> userNumber) {
        int strike = countStrike(randomNumber, userNumber);
        int ball = 0;
        for (int index = 0; index < 3; index++) {
            if (randomNumber.contains(userNumber.get(index))) {
                ball += 1;
            }
        }
        return ball - strike;
    }

    public boolean printResult(Integer strike, Integer ball) {
        boolean isAnswer = false;
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isAnswer = true;
            return isAnswer;
        }
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }
        if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        return isAnswer;
    }
}
