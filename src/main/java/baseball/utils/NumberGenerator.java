package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    private static final int MAX_NUMBERS_SIZE = 3;

    private static final int MIN_NUMBER = 1;

    private static final int MAX_NUMBER = 9;

    public static List<Integer> createNonDuplicateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < MAX_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
