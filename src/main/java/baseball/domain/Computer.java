package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.common.Constant.*;

public final class Computer {

    private final List<Integer> balls;

    public Computer() {
        this.balls = createRandomNumber();
    }

    public List<Integer> getBall() {
        return new ArrayList<>(balls);
    }

    public static List<Integer> createRandomNumber() {
        Set<Integer> answer = new HashSet<>();
        while (answer.size() < BALL_SIZE) {
            int num = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
            answer.add(num);
        }
        return new ArrayList<>(answer);
    }
}
