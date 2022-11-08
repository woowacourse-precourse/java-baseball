package baseball.verifier;

import baseball.verifiable.InputNumberEqualLength;
import baseball.verifiable.InputNumberInRange;

import static baseball.Constants.*;

public class VerifierInputToEndOrNewGame extends Verifier {
    public VerifierInputToEndOrNewGame() {
        this.addRule(new InputNumberEqualLength(INPUT_END_OR_NEW_GAME_LENGTH_MAX));
        this.addRule(new InputNumberInRange(INPUT_END_OR_NEW_GAME_LOWER_NUMBER, INPUT_END_OR_NEW_GAME_UPPER_NUMBER));
    }
}
