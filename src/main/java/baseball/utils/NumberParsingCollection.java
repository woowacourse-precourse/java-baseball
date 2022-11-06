package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberParsingCollection {
    public static List<Integer> changeStringToIntegers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < inputNumbers.length(); index++) {

            int integerNumber = Integer.parseInt(inputNumbers.substring(index, index + 1));
            numbers.add(integerNumber);
        }

        return numbers;
    }

    public static List<Integer> createRandomNumbersInRange(List<Integer> numbers, int count, int start, int end) {
        numbers.clear();

        for (; numbers.size() < count; ) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            numbers.add(randomNumber);
        }

        return numbers;
    }
}
