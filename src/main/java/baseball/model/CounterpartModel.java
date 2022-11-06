package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CounterpartModel {
    private final int resultNum;

    public CounterpartModel() {
        this.resultNum = pickNumberInRange(1, 9);
    }

    public int getResultNum() {
        return resultNum;
    }
}
