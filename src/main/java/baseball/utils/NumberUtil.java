package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtil {
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 9;
    private static final int LIMIT_SIZE = 3;

    public static List<Integer> getRandomNumberList() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < LIMIT_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_VALUE, END_VALUE);
            if (isUnique(randomNumbers, randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    private static boolean isUnique(List<Integer> randomNumberList, int randomNumber) {
        return !randomNumberList.contains(randomNumber);
    }

    public static List<Integer> getNumberList(String numbers) {
        return numbers.chars()
                .map(n -> n - '0')
                .boxed()
                .collect(Collectors.toList());
    }
}
