package baseball;

import java.util.LinkedList;
import java.util.Queue;

public class Referee {

    private final int MAX_NUMBER_SIZE = 3;
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    static final String THREE_STRIKE = "3스트라이크";

    private static Referee instance;

    public static Referee getInstance() {
        if (instance == null) {
            instance = new Referee();
        }
        return instance;
    }

    public String judge(String input, String answer) {
        int strike = countStrike(input, answer);
        int ball = countBall(input, answer);
        return createJudgement(strike, ball);
    }

    public int countStrike(String input, String answer) {
        int count = 0;
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public int countBall(String input, String answer) {
        Queue<Character> compareTarget = new LinkedList<>();
        for (int i = 0; i < answer.length(); i++) {
            compareTarget.add(answer.charAt(i));
        }

        int count = 0;
        for (int inputIdx = 0; inputIdx < input.length(); inputIdx++) {
            char target = input.charAt(inputIdx);
            char firstChar = compareTarget.poll();

            if (compareTarget.contains(target)) {
                count++;
            }

            compareTarget.add(firstChar);
        }

        return count;
    }

    public String createJudgement(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        if (strike == MAX_NUMBER_SIZE) {
            return THREE_STRIKE;
        }
        if (strike == 0 && ball != 0) {
            return ball + BALL;
        }
        if (strike != 0 && ball == 0) {
            return strike + STRIKE;
        }
        return ball + BALL + " " + strike + STRIKE;
    }

    public boolean isThreeStrike(String judgement) {
        return (judgement == THREE_STRIKE);
    }
}
