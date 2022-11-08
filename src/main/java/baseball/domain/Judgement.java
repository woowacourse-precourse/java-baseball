package baseball.domain;

import java.util.List;

public class Judgement {
    public int correctCount(List<Integer> computer, List<Integer> player) {
        int size = player.size();
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (computer.contains(player.get(i))) {
                count++;
            }
        }

        return count;
    }

    public boolean hasPlace(List<Integer> computer, int placeIndex, int number) {
        return computer.get(placeIndex) == number;
    }
}
