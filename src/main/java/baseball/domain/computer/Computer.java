package baseball.domain.computer;

import baseball.util.BallCount;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Computer {

    private final Map<Integer, Integer> answer = new HashMap<>();

    public void initialize() {
        while (answer.size() < 3) {
            addNumber();
        }
    }

    public void addNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answer.containsKey(randomNumber)) {
            answer.put(randomNumber,answer.size());
        }
    }

    public BallCount calculateBallCount(String input) {
        int ball = 0;
        int strike = 0;
        for (int index = 0; index < 3; index++) {
            int num = input.charAt(index) - '0';
            ball += addBall(num, index);
            strike += addStrike(num, index);
        }

        return new BallCount(strike, ball);
    }

    private int addStrike(int num, int index) {
        if (answer.containsKey(num) && answer.get(num) == index) {
            return 1;
        }
        return 0;
    }

    private int addBall(int num, int index) {
        if (answer.containsKey(num) && answer.get(num) != index) {
            return 1;
        }
        return 0;
    }
}
