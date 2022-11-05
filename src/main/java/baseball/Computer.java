package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final Numbers answer;

    private Computer(Numbers answer) {
        this.answer = answer;
    }

    public static Computer generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < Numbers.LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return new Computer(new Numbers(answer));
    }
}
