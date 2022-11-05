package baseball.domain.user;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Opponent {
    private final List<Integer> goal;

    public Opponent(int start, int end, int count) {
        goal = initRandomGoal(start, end, count);
    }

    public static List<Integer> initRandomGoal(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

    public List<Integer> getGoal() {
        return goal;
    }
}
