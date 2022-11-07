package baseball.domain.user;

import baseball.domain.validate.NumberVerifier;
import baseball.domain.view.InputView;

public class User {

    public String inputNumbers;

    public User (String randomNumbers) {
        verifier(randomNumbers);
    }

    private void verifier(String randomNumbers) {
        do {
            inputNumbers = InputView.printNumbers();
        } while (!NumberVerifier.numberVerifier(randomNumbers, inputNumbers));
    }
}
