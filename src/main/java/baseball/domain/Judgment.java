package baseball.domain;

import java.util.List;

public class Judgment {
    public int correctCount(List<Integer> computer, List<Integer> player) {
        int result = 0;

        for (int i=0; i<player.size(); i++) {
            int playerNum = player.get(i);

            if (computer.contains(playerNum)) {
                result++;
            }
        }

        return result;
    }

    public boolean hasPlace(List<Integer> computer, int placeIndex, int number) {
//        if (computer.get(placeIndex) == number) {
//            return true;
//        }
        return computer.get(placeIndex) == number;
    }
}
