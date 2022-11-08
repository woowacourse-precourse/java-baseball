package baseball;

import java.util.List;

public class Judgement {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    /**
     * 플레이어 수와 컴퓨터 수를 비교해 판정 결과를 반환한다.
     */
    public String getJudgementResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ball = countSameNumbers(computerNumbers, playerNumbers);
        int strike = countSamePosition(computerNumbers, playerNumbers);

        if (ball > 0) {
            if (ball == strike) {
                return strike + STRIKE;
            }

            if (strike > 0) {
                ball = ball - strike;
                return ball + BALL + " " + strike + STRIKE;
            }

            return ball + BALL;
        }

        return NOTHING;
    }

    /**
     * 플레이어 수와 컴퓨터의 수를 비교해 동일한 개수를 반환한다.
     */
    public int countSameNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int count = 0;

        for (Integer number : playerNumbers) {
            if (computerNumbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    /**
     * 플레이어 수와 컴퓨터 수를 비교해 동일한 위치에 있는 개수를 반환한다.
     */
    public int countSamePosition(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int count = 0;

        for (int position = 0; position < computerNumbers.size(); position++) {
            if (computerNumbers.get(position).equals(playerNumbers.get(position))) {
                count++;
            }
        }

        return count;
    }
}
