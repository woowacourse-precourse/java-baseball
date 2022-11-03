package baseball;

import java.util.List;
import java.util.Objects;

public class GameResult {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String END_GAME_PHRASE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final int CNT_NUMBER = 3;

    public String getGameResult(List<Integer> computerNumbers, List<Integer> answer) {
        int strikeCount = countStrike(computerNumbers, answer);
        int ballCount = countBall(computerNumbers, answer);

        if (strikeCount != 3 && strikeCount > 0 && ballCount == 0) {
            return strikeCount + STRIKE;
        }

        if (strikeCount == 0 && ballCount > 0) {
            return ballCount + BALL;
        }

        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + BALL + " " + strikeCount + STRIKE;
        }

        if (strikeCount == 3 && ballCount == 0) {
            return strikeCount + STRIKE + System.lineSeparator() + END_GAME_PHRASE;
        }

        return NOTHING;
    }

    private int countStrike(List<Integer> computerNumbers, List<Integer> answer) {
        int strikeCount = 0;

        for (int idx = 0; idx < CNT_NUMBER; idx++) {
            if (Objects.equals(computerNumbers.get(idx), answer.get(idx))) {
                strikeCount += 1;
            }
        }

        return strikeCount;
    }

    private int countBall(List<Integer> computerNumbers, List<Integer> answer) {
        int ballCount = 0;
        final int firstIdx = 0;

        for (int idx = 0; idx < CNT_NUMBER; idx++) {
            int removedNumber = computerNumbers.get(firstIdx);
            int nowIdx = idx;

            computerNumbers.remove(firstIdx);
            ballCount += computerNumbers.stream().map(num -> num.equals(answer.get(nowIdx)))
                    .filter(bool -> bool.equals(true)).count();
            computerNumbers.add(removedNumber);
        }

        return ballCount;
    }
}