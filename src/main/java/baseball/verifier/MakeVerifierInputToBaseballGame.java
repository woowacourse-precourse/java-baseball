package baseball.verifier;

import baseball.BaseballConstants;
import baseball.BaseballGame;
import baseball.verifiable.CheckDuplicatedInput;
import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;

import static baseball.BaseballConstants.*;

public class MakeVerifierInputToBaseballGame implements MakeVerifier {
    private final Verifier verifier = new Verifier();

    public MakeVerifierInputToBaseballGame() {
        verifier.addRule(new CheckInputLength(DIGIT_MAX));
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
