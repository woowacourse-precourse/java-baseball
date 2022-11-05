package baseball.domain.validate;

import baseball.domain.view.OutputView;

public class NumberVerifier {
    public NumberVerifier() {

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


}
