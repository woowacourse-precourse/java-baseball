package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    public static final int COMPUTER_INPUT_COUNT = 3;

    private List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateRandomNumbers() {
        while (numbers.size() < COMPUTER_INPUT_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
