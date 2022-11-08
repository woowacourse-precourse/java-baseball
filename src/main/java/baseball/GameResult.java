package baseball;

import java.util.List;

public class GameResult {

    private int strike;
    private int ball;

    private boolean isGameEnd;

    public GameResult() {
        this.strike = 0;
        this.ball = 0;
        this.isGameEnd = false;

    }

    public void setGameResult(List<Integer> inputs, List<Integer> answers) {
        int i = 0;
        while (i < answers.size()) {
            if (answers.get(i).equals(inputs.get(i))) {
                strike++;
            } else if (answers.contains(inputs.get(i))) {
                ball++;
            }
            i++;
        }
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public void getResult() {
        if (isNothing()) {
            System.out.println("낫싱");
        }
        if (isThreeStrike()) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isGameEnd = true;
        }
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }else if (ball > 0) {
            System.out.println(ball + "볼");
        }

    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public void resetGameResult() {
        strike = 0;
        ball = 0;
        isGameEnd = false;

    }
}
