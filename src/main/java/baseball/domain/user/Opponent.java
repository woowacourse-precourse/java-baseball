package baseball.domain.user;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static baseball.controller.Rule.*;

public class Opponent {
    private final List<Integer> goal;

    public Opponent() {
        goal = initRandomGoal();
    }

    public List<Integer> initRandomGoal() {
        return Randoms.pickUniqueNumbersInRange(
                START_NUMBER.getValue(),
                END_NUMBER.getValue(),
                LENGTH.getValue());
    }

    public List<Integer> getGoal() {
        return goal;
    }
}
