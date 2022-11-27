package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public int strikeCount = 0;
    public int ballCount = 0;
    public final int ballsLength = 3;
    final String strikeCall = "스트라이크";
    final String ballCall = "볼";
    final String Nothing = "낫싱";

    public Game() {

    }

    public void checkBallCounts(Balls playerBalls, Balls computerBalls) {
        for (int i = 0; i < ballsLength; i++) {
            if (isStrike(playerBalls, computerBalls, i)) {
                strikeCount++;
            }
            if (isBall(playerBalls, computerBalls, i)) {
                ballCount++;
            }
        }
    }

    private boolean isStrike(Balls playerBalls, Balls computerBalls, int i) {
        return playerBalls.get(i).equals(computerBalls.get(i));
    }

    private boolean isBall(Balls playerBalls, Balls computerBalls, int i) {
        return computerBalls.contains(playerBalls.get(i)) && computerBalls.indexOf(playerBalls.get(i)) != i;
    }

    public void initializeBallCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public String printMessage() {
        if (strikeCount == 0 && ballCount != 0) {
            return ballCount + ballCall;
        }
        if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + strikeCall;
        }
        if (strikeCount != 0) {
            return ballCount + ballCall + " " + strikeCount + strikeCall;
        }
        return Nothing;
    }
}
