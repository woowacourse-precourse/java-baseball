package baseball.game;

import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;
import camp.nextstep.edu.missionutils.Console;

import static baseball.Message.REGAME;

public class BaseballGame {

    final static String START = "1";
    final static String END = "2";
    PlayerNumber playerNumber;
    TargetNumber targetNumber;
    BallCounter ballCounter;

    public BaseballGame(PlayerNumber playerNumberImpl, TargetNumber targetNumber, BallCounter ballCounter) {
        this.playerNumber = playerNumberImpl;
        this.targetNumber = targetNumber;
        this.ballCounter = ballCounter;

    }

    public void start() {
        do {
            playGame();
        } while(continueGame());
    }

    public void playGame() {

        targetNumber.generateTargetNumber();

        do {
            playerNumber.setPlayerNumber();
        } while (ballCounter.countScore(playerNumber, targetNumber));
    }

    public boolean continueGame() {
        String continueInput;

        System.out.println(REGAME);
        continueInput = Console.readLine();
        checkValidationInput(continueInput);

        return continueInput.equals(START);
    }

    public void checkValidationInput(String input) {
        if (input.equals(START) || input.equals(END)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
