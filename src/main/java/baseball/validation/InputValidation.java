package baseball.validation;

public class InputValidation {
    public boolean isNotThreeLetters(String input) {
        return input.length() != 3;
    }

    public boolean isNot1To9(String input) {
        char[] chars = input.toCharArray();

        for (char letter : chars) {
            if (!('1' <= letter && letter <= '9')) {
                return true;
            }
        }

        return false;
    }
}
