package baseball.computer;

import java.util.List;

public class BallAndStrikeCounter {
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void countBallAndStrike(List<Character> baseballNumber, String number) {
        ball = countBall(baseballNumber, number);
        strike = countStrike(baseballNumber, number);
    }

    private int countBall(List<Character> baseballNumber, String number) {
        int count = 0;
        for (int unitNum = 0; unitNum < baseballNumber.size(); unitNum++) {
            if (!(baseballNumber.get(unitNum).equals(number.charAt(unitNum)))
                    && baseballNumber.contains(number.charAt(unitNum))) {
                count++;
            }
        }
        return count;
    }

    private int countStrike(List<Character> baseballNumber, String number) {
        int count = 0;
        for (int unitNum = 0; unitNum < baseballNumber.size(); unitNum++) {
            if (baseballNumber.get(unitNum).equals(number.charAt(unitNum))) {
                count++;
            }
        }
        return count;
    }
}
