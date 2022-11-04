package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class GameUtil {
    public static List<Integer> splitNumberToOneDigitNumbers(int number) {
        List<Integer> oneDigitNumbers = new ArrayList<>();

        while (number > 0) {
            oneDigitNumbers.add(number % 10);
            number /= 10;
        }

        Collections.reverse(oneDigitNumbers);

        return oneDigitNumbers;
    }

    public static int pickNumber(int numberDigit) {
        int number = pickOneDigitNumber();

        for (int length = 1; length < numberDigit; length++) {
             number = appendRandomOneDigit(number);
        }

        return number;
    }

    private static int pickOneDigitNumber() {
        return Randoms.pickNumberInRange(1,9);
    }

    private static int appendRandomOneDigit(int number) {
        List<Integer> oneDigitNumbers = splitNumberToOneDigitNumbers(number);
        int randomOneDigitNumber = pickOneDigitNumber();

        if (oneDigitNumbers.contains(randomOneDigitNumber)) {
            return appendRandomOneDigit(number);
        }

        return number + (randomOneDigitNumber * (int) Math.pow(10, oneDigitNumbers.size()));
    }

    public static boolean isValidNumber(int number) {
        List<Integer> oneDigitNumbers = splitNumberToOneDigitNumbers(number);

        if (countOneDigitNumbers(oneDigitNumbers, false) != 3) {
            return false;
        }

        if (countOneDigitNumbers(oneDigitNumbers, true) != 3) {
            return false;
        }

        if (isZeroInOneDigitNumbers(oneDigitNumbers)) {
            return false;
        }

        return true;
    }

    private static long countOneDigitNumbers(List<Integer> oneDigitNumbers, boolean deduplicate) {
        if (deduplicate) {
            return oneDigitNumbers.stream().distinct().count();
        }

        return oneDigitNumbers.size();
    }

    private static boolean isZeroInOneDigitNumbers(List<Integer> oneDigitNumbers) {
        return !oneDigitNumbers.stream().allMatch(oneDigitNumber -> oneDigitNumber > 0);
    }
}
