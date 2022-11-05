package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void redefineNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void pickRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        redefineNumbers(randomNumbers);
    }
}
