package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    int strike = 0;
    int ball = 0;

    public final int ballsLength = 3;
    Player player = new Player();
    Validator validator = new Validator();

    final String strikeCall = "스트라이크";
    final String ballCall = "볼";
    final String Nothing = "낫싱";

    public Game() {

    }

    public Balls makeComputerBalls() {
        List<Ball> comBalls = new ArrayList<>();

        while (comBalls.size() != ballsLength) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1, 9));
            if (!comBalls.contains(ball)) {
                comBalls.add(ball);
            }
        }
        return new Balls(comBalls);
    }

    public void checkBallCounts(Balls playerBalls, Balls computerBalls) {
        for (int i = 0; i < ballsLength; i++) {
            if (isStrike(playerBalls, computerBalls, i)) {
                strike++;
            }
            if (isBall(playerBalls, computerBalls, i)) {
                ball++;
            }
        }
    }

    private boolean isStrike(Balls playerBalls, Balls computerBalls, int i) {
        return playerBalls.get(i).equals(computerBalls.get(i));
    }

    private boolean isBall(Balls playerBalls, Balls computerBalls, int i) {
        return computerBalls.contains(playerBalls.get(i))&&computerBalls.indexOf(playerBalls.get(i))!=i;
    }
}
