package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Util.Valid.validNumberList;

public class Computer {
    private List<Integer> randomNumber;
    private static final boolean INVALID = false;

    public void init() {
        while (validNumberList(randomNumber) == INVALID) {
            makeRandomList();
        }
    }

    public void makeRandomList() {
        randomNumber = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(number)) {
                randomNumber.add(number);
            }
        }
    }

    public int addBallScore(List<Integer> userNumbers) {
        int ball = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            if (randomNumber.contains(userNumbers.get(i))
                    && userNumbers.get(i) != randomNumber.get(i)) {
                ball++;
            }
        }
        return ball;
    }

    public int addStrikeScore(List<Integer> userNumbers) {
        int strike = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i) == randomNumber.get(i)) {
                strike++;
            }
        }
        return strike;
    }
}
