package baseball;

public class UserInputNumbers {
    static final int NUMBER_LENGTH = 3;
    static final int START_IDX = 0;
    static final int NOT_DUPLICATE_NUMBER = 1;

    private int first;
    private int second;
    private int third;

    public UserInputNumbers(String numbers) {
        if(validUserInputNumber(numbers)){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static boolean validUserInputNumber(String numbers) {
        if (numbers.length()!=NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (!isDigit(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!duplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isDigit(String num) {
        for (int idx=START_IDX; idx<num.length(); idx++) {
            if (!Character.isDigit(num.charAt(idx))) {
                return false;
            }
        }
        return true;
    }

    public static boolean duplicateNumber(String numbers) {
        for (int idx=START_IDX; idx<numbers.length(); idx++) {
            if (numberCount(numbers, numbers.charAt(idx))!=NOT_DUPLICATE_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static int numberCount(String numbers, char num) {
        return (int) numbers.chars()
                .filter(c -> c == num)
                .count();
    }
}
