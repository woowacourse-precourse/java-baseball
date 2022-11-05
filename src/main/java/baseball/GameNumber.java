package baseball;

import java.util.Collections;
import java.util.List;

import static baseball.Constant.*;

public class GameNumber {
    private final List<Integer> gameNums;

    public GameNumber(List<Integer> gameNums) {
        this.gameNums = gameNums;
    }

    public int getStrikes(UserNumber userNumber) {
        List<Integer> userNums = userNumber.getUserNums();
        int strikes = 0;
        for (int position = 0; position < RANGE; position++) {
            strikes += checkStrike(position, userNums.get(position));
        }
        return strikes;
    }

    public int getBalls(UserNumber userNumber) {
        List<Integer> userNums = userNumber.getUserNums();
        int balls = 0;
        for (int position = 0; position < RANGE; position++) {
            balls += checkBall(userNums.get(position), position);
        }
        return balls;
    }

    private int checkStrike(int position, int userNum) {
        int strike = 0;
        if (gameNums.get(position) == userNum) {
            return strike + 1;
        }
        return strike;
    }

    private int checkBall(int userNum, int positionOfUserNum) {
        int ball = 0;
        for (int position = 0; position < RANGE; position++) {
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
