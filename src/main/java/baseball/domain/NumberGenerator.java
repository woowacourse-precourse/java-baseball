package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    public List<Integer> createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();

        // 3개의 숫자가 담길 때까지
        // 만약 이미 존재하는 숫자가 있는 경우 담지 않는다.
        // 만약 존재하는 숫자가 없는 경우 담는다.
        while (numbers.size() < 3) {
            int number = new Random().nextInt(9) + 1;
            if (numbers.contains(number)) {
                continue;
            } else {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
