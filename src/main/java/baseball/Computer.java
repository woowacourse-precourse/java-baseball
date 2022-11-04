package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final List<Integer> answer;

    public Computer() {
        this.answer = getAnswer();
    }

    private List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            addRandomNumber(answer);
        }
        return answer;
    }

    private static void addRandomNumber(List<Integer> answer) {
        Integer randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }
}
