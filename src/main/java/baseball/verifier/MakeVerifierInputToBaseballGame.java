package baseball.verifier;

import baseball.verifiable.CheckDuplicatedInput;
import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;

import static baseball.BaseballConstants.*;

public class MakeVerifierInputToBaseballGame extends Verifier {
    public MakeVerifierInputToBaseballGame() {
        this.addRule(new CheckInputLength(DIGIT_MAX));
        this.addRule(new CheckInputRange(LOWER_NUMBER, UPPER_NUMBER));
        this.addRule(new CheckDuplicatedInput());
    }
}
