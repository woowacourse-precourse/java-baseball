package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.Set;

public class Application {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputNumber = readLine();
        isValidInput(inputNumber);
    }

    private static void isValidInput(String input) {
        isDuplicated(input);
        input.chars().forEach(c -> isDigitRange((char) c));
        isRightLength(input);
    }

    private static void isDuplicated(String str) {
        Set<Character> stringCharSet = new HashSet<>();
        str.chars().forEach(c -> stringCharSet.add((char) c));
        if (stringCharSet.size() != CNT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static void isDigitRange(Character charSingleDigit) {
        System.out.printf(String.valueOf(charSingleDigit));
        if (charSingleDigit < '0' + MIN_NUMBER) {
            throw new IllegalArgumentException();
        } else if (charSingleDigit > '0' + MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static void isRightLength(String input) {
        if (input.length() != CNT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
