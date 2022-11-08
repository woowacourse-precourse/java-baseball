package baseball;

import java.util.List;

public class Judge {

    public int countBall(List<Integer> hitterNumber, List<Integer> pitcherNumber) {
        return (int) hitterNumber.stream()
                .filter(pitcherNumber::contains)
                .count();
    }

    public int countStrike() {
        return 1;
    }

    public int countNoting() {
        return 1;
    }
}
