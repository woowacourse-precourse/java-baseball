package baseball;

import java.util.ArrayList;

public class BaseballUmpire {

    private int ball;
    private int strike;

    public BaseballUmpire() {
        this.strike = 0;
        this.ball = 0;
    }

    private void ballReader(int userBall, int computerBall, boolean isStrike) {
        if (isStrike && userBall == computerBall) {
            this.strike++;
        } else if (userBall == computerBall) {
            this.ball++;
        }
    }

    private void refereeBaseball(int userBall, ArrayList<Integer> computerBalls, int ballCount) {
        int computerBall;
        boolean isStrike;

        for (int computerBallCount = 0; computerBallCount < computerBalls.size();
            computerBallCount++) {
            computerBall = computerBalls.get(computerBallCount);
            isStrike = (ballCount == computerBallCount);
            ballReader(userBall, computerBall, isStrike);
        }
    }

    public boolean throwBall(String userBalls, ArrayList<Integer> computerBalls) {
        for (int ballCount = 0; ballCount < userBalls.length(); ballCount++) {
            int userBall = userBalls.charAt(ballCount) - '0';
            refereeBaseball(userBall, computerBalls, ballCount);
        }

        Console.printHint(this.strike, this.ball);

        if (this.strike == 3) {
            return false;
        }

        return true;
    }

}
