package baseball;


public class NumberUtil {
    public static boolean noDuplicateCheck(String str) {
        if (str == null) {
            return true;
        }
        return str.chars().distinct().count() == str.length();
    }
}
