package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    public static List<Integer> getUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();

        String input = getInput();

        isValidInput(input);

        String[] digits = input.split("");

        for (String digit : digits) {
            int eachNumber = numberOf(digit);

            userNumbers.add(eachNumber);
        }

        return userNumbers;
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static void isValidInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("input should have three digits");
        }
    }

    private static int numberOf(String digit) {
        try {
            return Integer.parseInt(digit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input should be integer", e);
        }
    }
}
