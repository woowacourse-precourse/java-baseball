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

    static void getGameScore(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikeCnt = countStrike(userNumbers, computerNumbers);
        int ballCnt = countBall(userNumbers, computerNumbers);
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0 && ballCnt != 0) {
            System.out.println(ballCnt + "볼");
        } else if (strikeCnt != 0 && ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else if (strikeCnt != 0 && ballCnt != 0) {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }
}
