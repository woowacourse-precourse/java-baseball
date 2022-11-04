package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    static final int NUMBER_OF_DIGIT = 3;

    private UserInput() {
    }

    public static String getUserInput() {
        String input = Console.readLine();
        validateNumber(input);
        validateNumberOfDigits(input);
        validateDuplicateNumber(input);

        final int inputNumber = Integer.parseInt(input);
        return input;
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static void validateNumberOfDigits(String input) {
        int inputNum = Integer.parseInt(input);
        int numberOfDigits = (int) (Math.log10(inputNum) + 1);

        if (numberOfDigits != NUMBER_OF_DIGIT) {
            throw new IllegalArgumentException("3지리 숫자를 입력해주세요.");
        }
    }

    private static void validateDuplicateNumber(String input) {
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            for (int j = i + 1; j < NUMBER_OF_DIGIT; j++) {
                compareChar(input.charAt(i), input.charAt(j));
            }
        }
    }

    private static void compareChar(char ch1, char ch2) {
        if (ch1 == ch2) {
            throw new IllegalArgumentException("중복되지 않는 3자리 숫자를 입력해주세요.");
        }
    }
}
