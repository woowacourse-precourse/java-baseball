package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private List<Integer> numbers = new ArrayList<>();

    public void generateNumber() {
        initializeNumbers();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!numbers.contains(randomNumber))
                numbers.add(randomNumber);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void initializeNumbers() {
        this.numbers = new ArrayList<>();
    }
}
