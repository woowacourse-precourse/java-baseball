package baseball;

import java.util.List;

public class Judge {

    static final int GAME_COUNT = 3;

    static int countStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikeCnt = 0;
        for (int i = 0; i < GAME_COUNT; i++) {
            if (userNumbers.get(i) == computerNumbers.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    static int countBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int ballCnt = 0;
        for (int i = 0; i < GAME_COUNT; i++) {
            if (userNumbers.get(i) == computerNumbers.get((i + 1) % 3)) {
                ballCnt++;
            } else if (userNumbers.get(i) == computerNumbers.get((i + 2) % 3)) {
                ballCnt++;
            }
        }
        return ballCnt;
    }
}
