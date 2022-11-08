package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    private static final String ZERO = "0";

    private UserUtil() {
    }

    public static List<Integer> getUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();

        String input = getInput();

        validInput(input);

        addInputToUserNumbers(userNumbers, input);

        return userNumbers;
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static void validInput(String input) {
        if (!hasThreeDigits(input)) {
            throw new IllegalArgumentException("input should have three digits");
        }

        if (input.contains(ZERO)) {
            throw new IllegalArgumentException("input cannot contains zero");
        }
    }

    private static boolean hasThreeDigits(String input) {
        return input.length() == 3;
    }

    private static int numberOf(String digit) {
        try {
            return Integer.parseInt(digit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input should be integer", e);
        }
    }

    private static void addInputToUserNumbers(List<Integer> userNumbers, String input) {
        String[] digits = input.split("");

        for (String digit : digits) {
            int eachNumber = numberOf(digit);

            userNumbers.add(eachNumber);
        }
    }

    public static boolean checkRestartOrExit() {
        String input = getInput();

        int number = numberOf(input);

        if (number == 1) {
            return true;
        }

        if (number == 2) {
            return false;
        }

        throw new IllegalArgumentException("input should be 1 or 2");
    }
}
