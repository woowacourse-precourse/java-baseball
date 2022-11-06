package baseball.verifier;

import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;

public class MakeVerifierInputToEndOrNewGame implements MakeVerifier {
    private final static int NUMBER_LENGTH_MAX = 1;
    private final static int LOWER_NUMBER = 1;
    private final static int UPPER_NUMBER = 2;
    private final Verifier verifier = new Verifier();

    public MakeVerifierInputToEndOrNewGame() {
        verifier.addRule(new CheckInputLength(NUMBER_LENGTH_MAX));
        verifier.addRule(new CheckInputRange(LOWER_NUMBER, UPPER_NUMBER));
    }

    @Override
    public String checkValid(String input) {
        if (!(verifier.validates(input)))
            throw new IllegalArgumentException("잘못된 입력입니다.");
        return input;
    }
}
