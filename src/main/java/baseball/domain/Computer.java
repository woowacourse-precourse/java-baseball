package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> baseballNumber = new ArrayList<>();

    public void createBaseballNumber() {
        while (baseballNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumber.contains(randomNumber)) {
                baseballNumber.add(randomNumber);
            }
        }
    }

    public int checkStrike(List<Integer> question) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (question.get(i) == baseballNumber.get(i)) {
                strike++;
            }
        }

        return strike;
    }

    public int checkBall(List<Integer> question, int strike) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (baseballNumber.contains(question.get(i)) == true) {
                ball++;
            }
        }

        return ball - strike;
    }

    public boolean checkNothing(List<Integer> question) {
        for (int i = 0; i < 3; i++) {
            if (baseballNumber.contains(question.get(i)) == true) {
                return false;
            }
        }
        return true;
    }
}
