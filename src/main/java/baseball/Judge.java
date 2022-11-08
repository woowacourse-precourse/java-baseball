package baseball;

import java.util.List;

public class Judge {

    public int countBall(List<Integer> hitterNumber, List<Integer> pitcherNumber) {
        int count = 0;

        for (int hitterIndex = 0; hitterIndex < hitterNumber.size(); hitterIndex++) {
            count += getCount(hitterNumber, pitcherNumber, hitterIndex);
        }
        return count;
    }

    private int getCount(List<Integer> hitterNumber, List<Integer> pitcherNumber, int hitterIndex) {
        int count = 0;

        for (int pitcherIndex = 0; pitcherIndex < pitcherNumber.size(); pitcherIndex++) {
            if (hitterIndex == pitcherIndex) {
                continue;
            }
            if (hitterNumber.get(hitterIndex).equals(pitcherNumber.get(pitcherIndex))) {
                count++;
                break;
            }
        }
        return count;
    }

    public int countStrike(List<Integer> hitterNumber, List<Integer> pitcherNumber) {
        int count = 0;

        for (int numberIndex = 0; numberIndex < hitterNumber.size(); numberIndex++) {
            if (hitterNumber.get(numberIndex).equals(pitcherNumber.get(numberIndex))) {
                count++;
            }
        }
        return count;
    }

    public boolean isNoting(List<Integer> hitterNumber, List<Integer> pitcherNumber) {
        return countBall(hitterNumber, pitcherNumber) == 0;
    }

}
