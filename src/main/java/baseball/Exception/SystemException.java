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
}