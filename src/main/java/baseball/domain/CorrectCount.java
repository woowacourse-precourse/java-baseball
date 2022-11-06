package baseball.domain;

import java.util.List;

public class CorrectCount {
    public int compare(List<Integer> computer, List<Integer> player) {
        int definiteNumber = 0;
        for (int playerNumber : player) {
            if (computer.contains(playerNumber)) {
                definiteNumber++;
            }
        }
        return definiteNumber;
    }
}
