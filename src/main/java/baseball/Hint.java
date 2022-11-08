package baseball;

import static baseball.Constant.LENGTH_OF_NUMBER;
import static baseball.Constant.WIN_MSG;

import java.util.List;

public class Hint {

    private int strikeCount;
    private int ballCount;

    public void initHint() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void giveHint(List<Integer> computerNumber, List<Integer> userNumber) {
        for (int i = 0; i < LENGTH_OF_NUMBER; i++) {
            if (isStrike(computerNumber, userNumber.get(i), i)) {
                strikeCount++;
            } else if (isBall(computerNumber, userNumber.get(i))) {
                ballCount++;
            }
        }
    }

    public boolean isStrike(List<Integer> computerNumber, int userNumber, int index) {
        if (computerNumber.get(index) == userNumber) {
            return true;
        }
        return false;
    }

    public boolean isBall(List<Integer> computerNumber, int userNumber) {
        if (computerNumber.contains(userNumber)) {
            return true;
        }
        return false;
    }

    public boolean isThreeStrike() {
        if (strikeCount == LENGTH_OF_NUMBER) {
            System.out.println(WIN_MSG);
            return true;
        }
        return false;
    }

    public boolean isNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            return true;
        } else {
            return false;
        }
    }
}
