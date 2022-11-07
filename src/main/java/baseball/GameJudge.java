package baseball;

import java.util.List;

public class GameJudge {
    private int countStrike, countBall;
    private static final int COUNT_SIZE = 3;

    public void judgeGame(List<Integer> computer, List<Integer> player) {
        getGameResult(computer, player);
        judgeGameResult(countStrike, countBall);
    }

    private void judgeGameResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        } else if (strike == 0) {
            System.out.println(ball + "볼");
            return;
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }

    private void getGameResult(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < COUNT_SIZE; i++) {
            if (computer.get(i) == player.get(i)) {
                strike += 1;
            } else if (player.contains(computer.get(i))) {
                ball += 1;
            }
        }

        this.countStrike = strike;
        this.countBall = ball;
    }
}