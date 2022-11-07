package baseball;

public class UtilMethods {
    public static boolean isNumeric(String s) {
        return s != null && s.matches("^[0-9]+");
    }
}
