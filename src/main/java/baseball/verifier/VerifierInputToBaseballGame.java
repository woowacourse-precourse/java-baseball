package baseball.verifier;

import baseball.verifiable.InputNumberHasDuplication;
import baseball.verifiable.InputNumberEqualLength;
import baseball.verifiable.InputNumberInRange;

import static baseball.BaseballConstants.*;

public class VerifierInputToBaseballGame extends Verifier {
    public VerifierInputToBaseballGame() {
        this.addRule(new InputNumberEqualLength(DIGIT_MAX));
        this.addRule(new InputNumberInRange(LOWER_NUMBER, UPPER_NUMBER));
        this.addRule(new InputNumberHasDuplication());
    }
}
