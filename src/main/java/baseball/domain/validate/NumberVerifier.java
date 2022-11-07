package baseball.domain.validate;

import baseball.domain.view.OutputView;

import static baseball.domain.util.InputNumbersConstants.*;

public class NumberVerifier {

    public static boolean numberVerifier(String randomNumbers, String inputNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < MAX_NUMBER_DIGITS; i++) {
            if (randomNumbers.charAt(i) == inputNumbers.charAt(i)) {
                strike++;
            } else if (randomNumbers.contains(String.valueOf(inputNumbers.charAt(i)))) {
                ball++;
            }
        }
        return OutputView.printResult(strike, ball);
    }
}
