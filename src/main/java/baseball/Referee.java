package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Computer.*;
import static baseball.User.*;

public class Referee {
    static final int MAX_SIZE = 3;

    private int ballCount;
    private int strikeCount;

    private List<Integer> computerNumbers;
    private List<Integer> userNumbers;

    public void resetReferee(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.ballCount = 0;
        this.strikeCount = 0;
        this.computerNumbers = computerNumbers;
        this.userNumbers = userNumbers;
    }

    public boolean isBall(int index) {
        if (computerNumbers.contains(userNumbers.get(index))) {
            return true;
        }
        return false;
    }

    public int countBall() {
        int count = 0;
        for (int index = 0; index < MAX_SIZE; index++) {
            if (isBall(index) && !isStrike(index)) {
                count += 1;
            }
        }
        return count;
    }
}
