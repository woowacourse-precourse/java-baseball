package baseball.util;

import java.util.List;

public class Util {
    public static boolean isNotDuplicated(List<Integer> numberList, int number) {
        return !numberList.contains(number);
    }

    public static void isCorrectInput(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력하세요.");
        }

        if (!numbers.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

    public static void isCorrectInputRestartNumber(int number) {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException("1또는 2의 숫자를 입력하세요.");
        }
    }
}
