package baseball;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class Baseball {
    private int targetNumber;

    int createTargetNumber() {
        int newTarget = pickNumberInRange(1, 999);
        this.targetNumber = newTarget;
        return newTarget;
    }
}
