package baseball;

import java.util.List;

class Referee {
    final int NOTHING = 0;
    final int BALL = 1;
    final int STRIKE = 2;
    List<Integer> answer;

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    int judgeNumber(int num, int index) {
        if (answer.get(index) == num) {
            return STRIKE;
        }
        if (answer.contains(num)) {
            return BALL;
        }
        return NOTHING;
    }
}
