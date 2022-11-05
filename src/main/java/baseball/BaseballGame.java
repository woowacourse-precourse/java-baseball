package baseball;

import baseball.verifiable.CheckDuplicatedInput;
import baseball.verifiable.CheckInputLength;
import baseball.verifiable.CheckInputRange;
import baseball.verifier.MakeVerifierInputToBaseballGame;
import baseball.verifier.MakeVerifierInputToEndOrNewGame;
import baseball.verifier.Verifier;


public class BaseballGame {
    private static final String NEW_GAME = "1";
    private final MakeVerifierInputToEndOrNewGame verifierInputToEndOrNewGame;
    private final MakeVerifierInputToBaseballGame verifierInputToBaseballGame;
    private final Computer computer;

    public BaseballGame() {
        verifierInputToEndOrNewGame = new MakeVerifierInputToEndOrNewGame();
        verifierInputToBaseballGame = new MakeVerifierInputToBaseballGame();
        computer = new Computer();
    }

    public void start() {

        View.printStartGame();
        do {
            startGame();
        } while (isEndGame());

    }

    private void startGame() {
        computer.makeRandomNumber();

    }

    private void playGame(){

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
