package baseball;

public class UserInputNumbers {
    static final int NUMBER_LENGTH = 3;
    static final int START_IDX = 0;

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
}
