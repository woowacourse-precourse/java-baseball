package baseball;

import java.util.List;

public class Game {
    private static final int DIGITS = 3;
    private static final String BALL_STR = "볼 ";
    private static final String STRIKE_STR = "스트라이크 ";
    private static final String NOTHING = "낫싱";
    private static final String THREE_STRIKE_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private void printHint(List<Character> answer, List<Character> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);

        System.out.println(makeHint(strike, ball));
        if(strike == DIGITS) {
            System.out.println(THREE_STRIKE_SENTENCE);
        }
    }

    private String makeHint (int strike, int ball) {
//        StringBuilder sb = new StringBuilder();
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
