package baseball;

public class Exception {
    public static boolean isRedundancy(int number) {
        if ((number / 100) == ((number / 10) % 10) && (number / 100) != 0 && ((number / 10) % 10) != 0)
            return true;
        if ((number / 100) == (number % 10) && (number / 100) != 0 && (number % 10) != 0)
            return true;
        if (((number / 10) % 10) == (number % 10) && ((number / 10) % 10) != 0 && (number % 100) != 0)
            return true;
        return false;
    }
    public static boolean isNumber(String number) {
        if (number.matches("[0-9]+"))
            return true;
        return false;
    }
}
