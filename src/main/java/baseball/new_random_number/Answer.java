package baseball.new_random_number;

import java.util.Collections;
import java.util.List;

public class Answer {

    private final List<RandomNumber> randomNumbers;

    Answer(List<RandomNumber> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public List<RandomNumber> randomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
