package baseball.domain.exception;

public class InputNumberException {

    public static void inputNumberVerifier(String numbers) {
        isNumbersLengthThree(numbers);
        isNumbersOneToNine(numbers);
    }

    public static void isNumbersLengthThree(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력 가능합니다.");
        }
    }

    public static void isNumbersOneToNine(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (numbers.charAt(i) == '0') {
                throw new IllegalArgumentException("1~9까지의 숫자만 입력 가능합니다.");
            }
        }
    }

    public static void isInputNumberOneOrTwo(int number) {
        if (number < 1 || 2 < number) {
            throw new IllegalArgumentException("1과 2만 입력 가능합니다.");
        }
    }
}
