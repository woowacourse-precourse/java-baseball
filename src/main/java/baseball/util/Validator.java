package baseball.util;

public class Validator {
    public static void validateThreeDigits(int input) {
        if ((input < 111) || (input > 999)) {
            throw new IllegalArgumentException(Errors.NUMBERS_THREE_DIGITS.getValue());
        }
    }

    public static void validateDuplicateNumber(int input) {
        if (isDuplicateNumber(input)) {
            throw new IllegalArgumentException(Errors.NUMBERS_DUPLICATE_NUMBER.getValue());
        }
    }

    private static boolean isDuplicateNumber(int input){
        int firstNumberInt = input/100;
        int secondNumberInt = input%100/10;
        int thirdNumberInt = input%10;

        return (firstNumberInt == secondNumberInt)
                ||(secondNumberInt == thirdNumberInt)
                ||(thirdNumberInt == firstNumberInt);
    }
}
