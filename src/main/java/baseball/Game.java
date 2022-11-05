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
}
