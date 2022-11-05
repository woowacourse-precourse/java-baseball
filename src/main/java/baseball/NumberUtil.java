package baseball;


public class NumberUtil {
    public static boolean lengthCheck(String str, int length) {
        if (str == null) {
            return length == 0;
        }
        return str.length() == length;
    }

    public static boolean numericBoundCheck(String str, int start, int end) {
        if (str == null) {
            return false;
        }
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isDigit)
                .mapToInt(Character::getNumericValue)
                .filter(i -> start <= i && i <= end)
                .count() == str.length();
    }

    public static boolean noDuplicateCheck(String str) {
        if (str == null) {
            return true;
        }
        return str.chars().distinct().count() == str.length();
    }
}
