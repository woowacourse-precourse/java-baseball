package baseball.verifier;

import baseball.verifiable.CheckDuplicatedInput;
import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;

public class MakeVerifierInputToBaseballGame implements MakeVerifier {
    private final static int NUMBER_LENGTH_MAX = 3;
    private final static int LOWER_NUMBER = 1;
    private final static int UPPER_NUMBER = 9;
    private final Verifier verifier = new Verifier();

    public MakeVerifierInputToBaseballGame() {
        verifier.addRule(new CheckInputLength(NUMBER_LENGTH_MAX));
        verifier.addRule(new CheckInputRange(LOWER_NUMBER, UPPER_NUMBER));
        verifier.addRule(new CheckDuplicatedInput());
    }

    @Override
    public String checkValid(String input) {
        if (!(verifier.validates(input)))
            throw new IllegalArgumentException("잘못된 입력입니다.");
        return input;
    }
}
