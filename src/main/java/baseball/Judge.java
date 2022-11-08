package baseball;

import java.util.Set;

public class Judge {

    public int countBall(Set<Integer> hitterNumber, Set<Integer> PitcherNumber) {
        Set<Integer> intersectSet = hitterNumber;
        intersectSet.retainAll(PitcherNumber);

        return intersectSet.size();
    }

    public int countStrike() {
        return 1;
    }

    public int countNoting() {
        return 1;
    }
}
