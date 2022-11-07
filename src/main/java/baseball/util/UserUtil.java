package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    public static List<Integer> getUserNumbers() {
        List<Integer> userNumbers = new ArrayList<>();

        String input = getInput();

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

    private static int numberOf(String digit) {
        return Integer.parseInt(digit);
    }
}
