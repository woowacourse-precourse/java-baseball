package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Number {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    public static final int NUMBERS_SIZE = 3;

    public static List<Integer> getOpponentNumbersInList() {
        List<Integer> opponentNumbers = new ArrayList<>();
        while (opponentNumbers.size() < NUMBERS_SIZE) {
            int readNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            addNumber(opponentNumbers, readNumber);
        }
        return opponentNumbers;
    }

    public static String getUserNumbers() {
        String readNumber = Console.readLine();
        validateDigits(readNumber);
        validateNumbers(readNumber);
        return readNumber;
    }

    public static void addNumber(List<Integer> numbersList, int number) {
        if (!isDuplicated(numbersList, number)) {
            numbersList.add(number);
        }
    }

    public static boolean isDuplicated(List<Integer> numbersList, int number) {
        return numbersList.contains(number);
    }

    public static void validateDigits(final String numbers) {
        if (numbers.length() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("Enter a three-digit number.");
        }
    }

    public static void validateNumbers(final String numbers) {
        if (!Pattern.matches("^[0-9]*$", numbers)) {
            throw new IllegalArgumentException("Enter only numbers.");
        }
        if (numbers.contains("0")) {
            throw new IllegalArgumentException("Enter only numbers from 1 to 9.");
        }
    }
}
