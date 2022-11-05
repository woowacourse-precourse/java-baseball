package baseball;

import java.util.List;

public class Game {
    private static final String BALL_STR = "볼 ";
    private static final String STRIKE_STR = "스트라이크 ";
    private static final String NOTHING = "낫싱";


    public String makeHint (List<Character> answer, List<Character> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);
        if(strike != 0) {
            if(ball != 0) {
                return ball + BALL_STR + strike + STRIKE_STR;
            }
            return strike + STRIKE_STR;
        }
        if(ball != 0) {
            return ball + BALL_STR;
        }
        return NOTHING;
    }

    private int countStrike(List<Character> answer, List<Character> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx) == input.get(idx)) {
                count++;
            }
        }
        return count;
    }

    private int countBall(List<Character> answer, List<Character> input) {
        int count = 0;
        for(int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx) != input.get(idx) && input.contains(answer.get(idx))) {
                count++;
            }
        }
        return count;
    }

}
