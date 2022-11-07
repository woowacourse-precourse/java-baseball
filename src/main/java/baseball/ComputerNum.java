package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum implements Number {

    public ComputerNum() {
    }

    @Override
    public List<Integer> createNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    @Override
    public void verifyNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            } else if (numbers.size() != 3 || numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
