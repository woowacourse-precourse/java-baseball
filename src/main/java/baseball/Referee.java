package baseball;

import java.util.List;

public class Referee {
    public int correctNumberCount(List<Integer> computerNumber, List<Integer> playerNumber) {
        int count = 0;
        for (int i = 0; i < playerNumber.size(); i += 1) {
            if (computerNumber.contains(playerNumber.get(i))) {
                count += 1;
            }
        }
        return count;
    }
}
