package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> ballCounts = new ArrayList<>();
    private static Computer instance = new Computer();

    private Computer() {
    }

    public static Computer getInstance() {
        return instance;
    }

    void initRandomNumbers() {
        while (this.ballCounts.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.ballCounts.contains(randomNumber)) {
                this.ballCounts.add(randomNumber);
            }
        }
    }
}
