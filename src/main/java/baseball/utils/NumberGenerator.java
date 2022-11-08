package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public static List<Integer> createNonDuplicateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
