package baseball;

import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static int[] getNumbersToUserNumber(String userNumber) {
        try {
            return Stream.of(userNumber.split("")).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static int getNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isValidUserNumber(String userNumber) {
        if (userNumber.length() != 3 || userNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        if (isDistinct(userNumber)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static boolean isDistinct(String number) {
        return number.length() != Stream.of(number.split("")).distinct().count();
    }
}
