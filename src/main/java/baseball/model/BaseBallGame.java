package baseball.model;

import baseball.model.balls.Balls;
import java.util.List;

public class BaseBallGame {
    private static final int MAX_SIZE = 3;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    private final Balls computerBalls;

    public BaseBallGame() {
        this.computerBalls = createComputerBalls();
    }

    private Balls createComputerBalls() {
        return Balls.createRandomNewBalls(MAX_SIZE, START_INCLUSIVE, END_INCLUSIVE);
    }

    public List<Integer> checkUserBallList(String userInoutNumber) {
        List<Integer> userBallList = NumberToListChanger.change(userInoutNumber);
        return computerBalls.judge(new Balls(userBallList)).reportToList();
    }
}
