package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Goal {

    private List<Integer> goalNumber = new ArrayList<>();

    public List<Integer> getGoalNumber() {
        return this.goalNumber;
    }

    public void setGoalNumber() {
        while (goalNumber.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if (!goalNumber.contains(randomNum)) {
                goalNumber.add(randomNum);
            }
        }
    }
}
