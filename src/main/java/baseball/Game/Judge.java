package baseball.Game;

import baseball.Utils.Output;
import java.util.List;

public class Judge {

    static final int GAME_COUNT = 3;
    private final List<Integer> userNumbers;
    private final List<Integer> computerNumbers;

    public Judge(List<Integer> userNumbers, List<Integer> computerNumbers) {
        this.userNumbers = userNumbers;
        this.computerNumbers = computerNumbers;
    }

    int countStrike() {
        int strikeCnt = 0;
        for (int i = 0; i < GAME_COUNT; i++) {
            if (userNumbers.get(i) == computerNumbers.get(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    int countBall() {
        int ballCnt = 0;
        for (int i = 0; i < GAME_COUNT; i++) {
            // 다음 index 값과 비교, index가 Game_Count를 넘으면 0으로 돌아감
            if (userNumbers.get(i) == computerNumbers.get((i + 1) % GAME_COUNT)) {
                ballCnt++;
            // 다음 index 값과 다를 경우, 다음 다음 index 값과 비교
            } else if (userNumbers.get(i) == computerNumbers.get((i + 2) % GAME_COUNT)) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    void printRoundScore() {
        int strikeCnt = countStrike();
        int ballCnt = countBall();
        System.out.println(Output.makeOutputString(strikeCnt, ballCnt));
    }
}
