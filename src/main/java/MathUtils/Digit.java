package MathUtils;

public class Digit {

    public static int findDigitNumber(int number, int where) {
        int digit = (int) Math.pow(10, where);
        int digit_under = (int) Math.pow(10, where - 1);

        int digit_number = (number % digit) / digit_under;

        return digit_number;
    }
}
