package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> answer;

    Computer() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public boolean isBall(int digit) {
        return answer.contains(digit);
    }

    public boolean isStrike(int index, int digit) {
        return answer.get(index) == digit;
    }

    public int judgeDigit(int index, int digit) {
        if (!isBall(digit)) {
            return 0;
        }
        if (!isStrike(index, digit)) {
            return 1;
        }
        return 2;
    }

    public void addJudgement(Result result, int index, int digit) {
        int judgement = judgeDigit(index, digit);
        if (judgement == 1) {
            result.addBall();
            return;
        }
        if (judgement == 2) {
            result.addStrike();
        }
    }
}
