package baseball.common;

public class StringUtil {

    private StringUtil() {

    }


    public static boolean isNullOrEmpty(String value) {
        if (value == null) {
            return true;
        }

        if (value.isBlank()) {
            return true;
        }

        return false;
    }
}
