package baseball;

import java.util.Collections;
import java.util.List;

public class GameNumber {
    private final List<Integer> gameNums;

    public GameNumber(List<Integer> gameNums) {
        this.gameNums = gameNums;
    }

    public int getStrikes(List<Integer> userNums) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            strikes += checkStrike(gameNums.get(i), userNums.get(i));
        }
        return strikes;
    }

    public int getBalls(List<Integer> userNums) {
        int balls = 0;
        for (int position = 0; position < 3; position++) {
            balls += checkBall(userNums.get(position), position);
        }
        return balls;
    }

    private int checkStrike(int gameNum, int userNum) {
        int strike = 0;
        if (gameNum == userNum) {
            return strike + 1;
        }
        return strike;
    }

    private int checkBall(int userNum,int positionOfUserNum) {
        int ball = 0;
        for (int position = 0; position < 3; position++) {
            if (position == positionOfUserNum) {
                continue;
            }
            if (gameNums.get(position) == userNum) {
                ball += 1;
                return ball;
            }
        }
        return ball;
    }

    public boolean isNothing(int strikes, int balls) {
        return strikes + balls == 0;
    }

    public List<Integer> getGameNums() {
        return Collections.unmodifiableList(this.gameNums);
    }
}
