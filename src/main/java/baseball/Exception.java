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
}
