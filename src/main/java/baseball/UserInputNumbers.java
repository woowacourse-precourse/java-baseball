package baseball;

public class UserInputNumbers {
    static final int NUMBER_LENGTH = 3;

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
        return true;
    }
}
