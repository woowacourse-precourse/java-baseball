package baseball.utils;

public class Utils {

    private static final String SPACE_REGEX = "\\s";

    public static String deleteAllSpace(String input) {
        return input.replaceAll(SPACE_REGEX, "");
    }

}
