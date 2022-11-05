package baseball;

import baseball.verifiable.CheckDuplicatedInput;
import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;
import baseball.verifier.MakeVerifierInputToBaseballGame;
import baseball.verifier.MakeVerifierInputToEndOrNewGame;
import baseball.verifier.Verifier;

public class BaseballGame {
    private final MakeVerifierInputToEndOrNewGame verifierInputToEndOrNewGame = new MakeVerifierInputToEndOrNewGame();
    private final MakeVerifierInputToBaseballGame verifierInputToBaseballGame = new MakeVerifierInputToBaseballGame();

    private static final String NEW_GAME = "1";

    public void play() {

        View.printStartGame();
        do {
            playGame();
        } while (isEndGame());

    }

    public void playGame() {

    }

    public boolean isEndGame() {
        View.printChoiceEndOrNewGame();
        String userInput = checkVerifierInputToEndOrNewGame(View.getUserInput());
        return userInput.equals(NEW_GAME);
    }

    private String checkVerifierInputToEndOrNewGame(String input) {
        return verifierInputToEndOrNewGame.checkValid(input);
    }
}
