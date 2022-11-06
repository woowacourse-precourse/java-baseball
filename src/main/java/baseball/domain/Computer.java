package baseball.domain;

import baseball.util.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class Computer {
    List<Integer> numbers;

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void redefineNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void pickRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Number.PRESCRIBED_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(Number.MIN_PICK, Number.MAX_PICK);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        redefineNumbers(randomNumbers);
    }
}
