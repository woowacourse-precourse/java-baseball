package baseball.verifier;

import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;

import static baseball.BaseballConstants.*;

public class MakeVerifierInputToEndOrNewGame extends Verifier {
    public MakeVerifierInputToEndOrNewGame() {
        this.addRule(new CheckInputLength(INPUT_END_OR_NEW_GAME_LENGTH_MAX));
        this.addRule(new CheckInputRange(INPUT_END_OR_NEW_GAME_LOWER_NUMBER, INPUT_END_OR_NEW_GAME_UPPER_NUMBER));
    }
}
