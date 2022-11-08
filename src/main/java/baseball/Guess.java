package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.GAME_FINISH;
import static baseball.Constant.WRITE_ANSWER;

public class Guess {
    public static String takeGuess() {
        System.out.print(WRITE_ANSWER);
        return Console.readLine();
    }

    public static void checkGuess(String input) throws IllegalArgumentException {
        if (input.length() != 3 || !isNumeric(input) || isRepeated(input))
            throw new IllegalArgumentException(GAME_FINISH);
    }

    public static List<Integer> splitGuess(String input) {
        List<Integer> userAnswer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String digitChar = String.valueOf(input.charAt(i));
            Integer digitInt = Integer.parseInt(digitChar);
            userAnswer.add(digitInt);
        }
        return userAnswer;
    }

    private static boolean isNumeric(String str) {
        boolean isNumeric;
        try {
            Integer.parseInt(str);
            isNumeric = true;
        } catch (NumberFormatException e) {
            isNumeric = false;
        }
        return isNumeric;
    }

    private static boolean isRepeated(String str) {
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char num = str.charAt(i);
            if (!chars.contains(num))
                chars.add(num);
            else
                return true;
        }
        return false;
    }
}
