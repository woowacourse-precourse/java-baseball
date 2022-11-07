package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.RuleConst.*;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateNumber() {
        this.numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_LENGTH) {
            Integer randomNumber = Randoms.pickNumberInRange(MINIMAL_RANDOM_INTEGER, MAXIMUM_RANDOM_INTEGER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
