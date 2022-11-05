package baseball.verifier;

import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;

public class MakeVerifierInputToEndOrNewGame implements MakeVerifier {
    private final Verifier verifier = new Verifier();

    public MakeVerifierInputToEndOrNewGame() {
        verifier.addRule(new CheckInputLength(1));
        verifier.addRule(new CheckInputRange(1, 2));
    }

    @Override
    public String checkValid(String input) {
        if (!(verifier.validates(input)))
            throw new IllegalArgumentException("잘못된 입력입니다.");
        return input;
    }
}
