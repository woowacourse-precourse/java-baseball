package baseball;

import java.util.List;

public class CheckBallCount {
    private static final int LENGTH = 3;

    public static int countStrike(List<Integer> userNumList, List<Integer> answer) {
        int count = 0;
        for (int index = 0; index < LENGTH; index++) {
            if (userNumList.get(index) == answer.get(index)) {
                count++;
            }
        }
        return count;
    }

    public static int countBall(List<Integer> userNumList, List<Integer> answer) {
        int count = 0;
        for (int index = 0; index < LENGTH; index++) {
            if (answer.contains(userNumList.get(index)) && answer.get(index) != userNumList.get(index)) {
                count++;
            }
        }
        return count;
    }
}
