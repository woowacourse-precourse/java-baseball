package baseball.domain;

import java.util.List;

public class TotalIncludedNumbers {
    public int compare(List<Integer> computer, List<Integer> player) {
        int countNumber = 0;
        for (int playerNumber : player) {
            if (computer.contains(playerNumber)) {
                countNumber++;
            }
        }
        return countNumber;
    }
}