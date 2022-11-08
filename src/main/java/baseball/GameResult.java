package baseball;

import java.util.List;

public class GameResult {

    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void setGameResult(List<Integer> answers, List<Integer> inputs) {
        for (int i = 0; i < 3; i++) {
            if (answers.get(i).equals(inputs.get(i))) {
                strike++;
            } else if (answers.contains(inputs.get(i))) {
                ball++;
            }
        }
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public  boolean getResult() {
        if (isNothing()) {
            System.out.println("낫싱");
        }
        if (isThreeStrike()) {
            System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
        return false;
    }
}
