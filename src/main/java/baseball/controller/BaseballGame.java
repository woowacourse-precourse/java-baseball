package baseball.controller;

import java.util.List;

public class BaseballGame {
    public final int STRIKE_COUNT;
    public final int BALL_COUNT;

    public BaseballGame(List<Integer> userNum, List<Integer> computerNum) {
        this.STRIKE_COUNT = setStrikeCount(userNum, computerNum);
        this.BALL_COUNT = setBallCount(userNum, computerNum);
    }

    private int setStrikeCount(List<Integer> userNum, List<Integer> computerNum) {
        return 0;
    }

    private int setBallCount(List<Integer> userNum, List<Integer> computerNum) {
        return 0;
    }
}
