package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private final List<Integer> numbers;

    public RandomNumbers() {
        this.numbers = generateComputerRandomNumbers();
    }

    private List<Integer> generateComputerRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int get(int i) {
        return numbers.get(i);
    }

    public int indexOf(int value) {
        return numbers.indexOf(value);
    }

    public int size() {
        return numbers.size();
    }

    @Override
    public String toString() {
        return "RandomNumbers{" +
                "numbers=" + numbers +
                '}';
    }
}
