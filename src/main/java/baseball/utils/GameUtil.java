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

    public static void validateNumber(int number) {
        List<Integer> oneDigitNumbers = splitNumberToOneDigitNumbers(number);

        if (countOneDigitNumbers(oneDigitNumbers, false) != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }

        if (countOneDigitNumbers(oneDigitNumbers, true) != 3) {
            throw new IllegalArgumentException("각각의 3자리 숫자가 중복되지 않게 입력해주세요.");
        }

        if (isZeroInOneDigitNumbers(oneDigitNumbers)) {
            throw new IllegalArgumentException("각가의 3자리 숫자에 0이 포함되지 않게 입력해주세요.");
        }
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
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
