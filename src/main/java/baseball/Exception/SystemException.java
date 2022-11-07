package baseball.Exception;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemException {
    private static final String Restart_OR_Exit = "[1-2]";

    public SystemException() {
    }

    public static boolean isValidRestartInput(String input) {
        Pattern pattern = Pattern.compile(Restart_OR_Exit);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean isValidInput(String input) {
        return isValidNumber(input) && isNotContainsZero(input) && isNotDuplicate(input);
    }

    public static boolean isValidNumber(String input) {
        return Integer.parseInt(input) >= 123 && Integer.parseInt(input) <= 987;
    }

    public static boolean isNotContainsZero(String input) {
        return (!input.contains("0"));
    }

    public static boolean isNotDuplicate(String input) {
        return Arrays.stream(input.split(""))
                .distinct()
                .count() == input.length();
    }
}