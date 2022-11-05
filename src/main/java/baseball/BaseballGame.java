package baseball;

import java.util.ArrayList;

public class BaseballGame {



    private int ball;
    private int strike;

    BaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.strike = 0;
        this.ball = 0;
    }

    void ballReader(int userball, int computerball, boolean isStrike) {
        if (isStrike && userball == computerball) {
            this.strike++;
        } else if (userball == computerball) {
            this.ball++;
        }
    }
    void refereeBaseball(int userBall, ArrayList<Integer> computerBalls, int ballCount) {
        int computerBall;
        boolean isStrike;
        for (int computerBallCount = 0; computerBallCount < computerBalls.size(); computerBallCount++) {
            computerBall = computerBalls.get(computerBallCount);
            isStrike = ballCount == computerBallCount;
            ballReader(userBall, computerBall, isStrike);
        }
    }

    void throwball(ArrayList<Integer> userBalls, ArrayList<Integer> computerBalls) {
        for (int ballCount = 0; ballCount < userBalls.size(); ballCount++) {
            int userBall = userBalls.get(ballCount);
            refereeBaseball(userBall, computerBalls, ballCount);
        }
    }


    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
