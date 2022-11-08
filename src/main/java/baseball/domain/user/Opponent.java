package baseball.domain.user;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.controller.Rule.END_NUMBER;
import static baseball.controller.Rule.START_NUMBER;

public class Opponent {
    private final List<Integer> goal;

    public Opponent() {
        goal = initRandomGoal();
    }

    public Opponent(List<Integer> goal) {
        this.goal = goal;
    }

    public List<Integer> initRandomGoal() {
        List<Integer> goal = new ArrayList<>();
        while (goal.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER.getValue(), END_NUMBER.getValue());
            if (!goal.contains(randomNumber)) {
                goal.add(randomNumber);
            }
        }
        return goal;
    }

    public List<Integer> getGoal() {
        return goal;
    }

}
