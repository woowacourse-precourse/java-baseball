package baseball;

import java.util.List;

public class CheckBallCount {
    private static final int LENGTH = 3;

    public static int countStrike(List<Integer> userNum, List<Integer> answer) {
        int count = 0;
        for (int index = 0; index < LENGTH; index++) {
            if (userNum.get(index) == answer.get(index)) {
                count++;
            }
        }
        return count;
    }

    
}
