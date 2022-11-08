package baseball;

import java.util.List;

public class Judge {

    public int countBall(List<Integer> hitterNumber, List<Integer> pitcherNumber) {
        return (int) hitterNumber.stream()
                .filter(pitcherNumber::contains)
                .count();
    }

    public int countStrike(List<Integer> hitterNumber, List<Integer> pitcherNumber) {
        int count = 0;

        for (int numberIndex = 0; numberIndex < hitterNumber.size(); numberIndex++) {
            if (hitterNumber.get(numberIndex) == pitcherNumber.get(numberIndex)) {
                count++;
            }
        }
        return count;
    }

    public boolean isNoting(List<Integer> hitterNumber, List<Integer> pitcherNumber) {
        return countBall(hitterNumber, pitcherNumber) == 0;
    }
}
