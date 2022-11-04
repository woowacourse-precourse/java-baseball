package baseball.verifier;

import baseball.verifiable.CheckDuplicatedInput;
import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;

public class MakeVerifierInputToBaseballGame implements MakeVerifier {
    private final Verifier verifier = new Verifier();

    public MakeVerifierInputToBaseballGame() {
        verifier.addRule(new CheckInputLength(3));
        verifier.addRule(new CheckInputRange(1, 9));
        verifier.addRule(new CheckDuplicatedInput());
    }

    @Override
    public void checkValid(String input) {
        if (verifier.validates(input))
            throw new IllegalArgumentException();
    }
}
