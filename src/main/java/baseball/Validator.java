package baseball;

public final class Validator {

    public static void isRangeOf(int maxDigit, int userNumber) throws IllegalArgumentException {
        int maxNumber = (int) Math.pow(10, maxDigit);

        if ((0 <= userNumber) && (userNumber < maxNumber)) {
            throw new IllegalArgumentException();
        }
    }

}
