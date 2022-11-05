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

    public static Computer generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return new Computer(new Numbers(answer));
    }

    public int strike(Numbers guess) {
        int countStrike = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (answer.get(i) == guess.get(i)) {
                countStrike++;
            }
        }
        return countStrike;
    }

    public int ball(Numbers guess) {
        int countBall = 0;
        for (int i = 0; i < LENGTH; i++) {
            int findIndex = answer.indexOf(guess.get(i));
            if (findIndex != -1 && findIndex != i) {
                countBall++;
            }
        }
        return countBall;
    }
}
