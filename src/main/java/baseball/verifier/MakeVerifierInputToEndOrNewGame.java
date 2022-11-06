package baseball.verifier;

import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;

import static baseball.BaseballConstants.*;

public class MakeVerifierInputToEndOrNewGame implements MakeVerifier {
    private final Verifier verifier = new Verifier();

    public MakeVerifierInputToEndOrNewGame() {
        verifier.addRule(new CheckInputLength(INPUT_END_OR_NEW_GAME_LENGTH_MAX));
        verifier.addRule(new CheckInputRange(INPUT_END_OR_NEW_GAME_LOWER_NUMBER, INPUT_END_OR_NEW_GAME_UPPER_NUMBER));
    }

    @Override
    public String checkValid(String input) {
        if (!(verifier.validates(input)))
            throw new IllegalArgumentException("잘못된 입력입니다.");
        return input;
    }
}
