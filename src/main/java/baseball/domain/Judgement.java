package baseball.domain;

import java.util.List;

public class Judgement {
    public int correctCount(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < player.size(); i++) {
            int playerNumber = player.get(i);
            if (computer.contains(playerNumber)) {
                result++; // result = result + 1
            }
        }
        return result;
    }

    public boolean hasPlace(List<Integer> computer, int place, int number) {
        return false;
    }
}
