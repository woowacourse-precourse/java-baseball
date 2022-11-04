package baseball.utils;

import baseball.Scoreboard;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameUtil {
    public static List<Integer> splitNumberToOneDigits(int number) {
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
        List<Integer> oneDigitNumbers = splitNumberToOneDigits(number);
        int randomOneDigitNumber = pickOneDigitNumber();

        if (oneDigitNumbers.contains(randomOneDigitNumber)) {
            return appendRandomOneDigit(number);
        }

        return number + (randomOneDigitNumber * (int) Math.pow(10, oneDigitNumbers.size()));
    }
}
