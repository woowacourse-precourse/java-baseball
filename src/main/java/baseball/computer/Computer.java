package baseball.computer;

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

    private void setNumbers(List<Integer> randomNumbers) {
        this.numbers = randomNumbers;
    }

    public void generateNumber() {
        this.numbers = new ArrayList<>();

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            Integer randomNumber = Randoms.pickNumberInRange(MINIMAL_RANDOM_INTEGER, MAXIMUM_RANDOM_INTEGER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        setNumbers(randomNumbers);
    }
}
