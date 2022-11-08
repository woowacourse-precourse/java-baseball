package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Numbers.LENGTH;

public class Computer {
    private final Numbers answer;

    private Computer(Numbers answer) {
        this.answer = answer;
    }

    public static Computer of(int... answer) {
        return new Computer(Numbers.of(answer));
    }

    public static Computer create() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(Numbers.MIN, Numbers.MAX);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return new Computer(Numbers.of(answer));
    }

    public Status status(User user) {
        return new Status(strike(user), ball(user));
    }

    private int strike(User user) {
        int countStrike = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (answer.get(i) == user.guess.get(i)) {
                countStrike++;
            }
        }
        return countStrike;
    }

    private int ball(User user) {
        int countBall = 0;
        for (int i = 0; i < LENGTH; i++) {
            int findIndex = answer.indexOf(user.guess.get(i));
            if (findIndex != -1 && findIndex != i) {
                countBall++;
            }
        }
        return countBall;
    }
}
