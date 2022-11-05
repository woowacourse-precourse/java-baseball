package baseball;

import java.util.List;

public class Game {


    public String makeHint (List<Character> answer, List<Character> input) {
        int strike = countStrike(answer, input);
        int ball = countBall(answer, input);
        if(strike != 0) {
            if(ball != 0) {
                return ball + "볼" + strike + "스트라이크 ";
            }
            return strike + "스트라이크";
        }
        if(ball != 0) {
            return ball + "볼";
        }
        return "낫싱";
    }

    public int countStrike(List<Character> answer, List<Character> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx) == input.get(idx)) {
                count++;
            }
        }
        return count;
    }

    public int countBall(List<Character> answer, List<Character> input) {
        int count = 0;
        for(int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx) != input.get(idx) && input.contains(answer.get(idx))) {
                count++;
            }
        }
        return count;
    }

}
