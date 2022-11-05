package baseball.domain.validate;

import baseball.domain.view.OutputView;

public class NumberVerifier {
    public static void inputNumberVerifier(String numbers) {
        isNumbersLengthThree(numbers);
        isNumbersOneToNine(numbers);
    }

    public static boolean numberVerifier(String randomNumbers, String inputNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumbers.charAt(i) == inputNumbers.charAt(i)) {
                strike++;
            } else if (randomNumbers.contains(String.valueOf(inputNumbers.charAt(i)))) {
                ball++;
            }
        }
        return OutputView.printResult(strike, ball);
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
}
