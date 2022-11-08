package baseball.model;

import baseball.constant.Config;

import java.util.List;

public class Hint {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = " ";

    int strikeCnt;
    int ballCnt;

    public void setCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        resetCount();
        countStrike(computerNumbers, playerNumbers);
        countBall(computerNumbers, playerNumbers);
        deduplicateCount();
    }

    private void resetCount() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    private void countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < Config.DIGIT_SIZE; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCnt++;
            }
        }
    }

    private void countBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < Config.DIGIT_SIZE; i++) {
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ballCnt++;
            }
        }
    }

    private void deduplicateCount() {
        ballCnt -= strikeCnt;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        if (strikeCnt == 0 && ballCnt == 0) {
            return NOTHING;
        }

        if (ballCnt > 0) {
            stringBuilder.append(ballCnt).append(BALL).append(BLANK);
        }

        if (strikeCnt > 0) {
            stringBuilder.append(strikeCnt).append(STRIKE);
        }

        return stringBuilder.toString().trim();
    }

    public boolean isMaxStrike() {
        return strikeCnt == Config.MAX_STRIKE;
    }
}
