package baseball.randomnumber;

import java.util.Collections;
import java.util.List;

public class RandomNumber {

    private final List<Integer> answer;

    RandomNumber(List<Integer> randomNumber) {
        this.answer = randomNumber;
    }

    public List<Integer> getAnswer() {
        return Collections.unmodifiableList(answer);
    }
}
