package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static List<Integer> generateUnduplicatedThreeNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            addUnduplicatedNumber(numbers);
        }
        return numbers;
    }

    private static void addUnduplicatedNumber(List<Integer> numbers) {
        Integer number = Randoms.pickNumberInRange(1, 9);
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
