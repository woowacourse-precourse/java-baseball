package baseball.domain;

import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final static String YES = "1";
    private final InputValidator inputValidator;

    private BallNumber ballNumber;

    public Player(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public BallNumber getBallNumber() {
        return ballNumber;
    }

    public void readBallNumber() throws IllegalArgumentException {
        String ballNumberString = Console.readLine();
        inputValidator.validateBallNumberString(ballNumberString);

        ballNumber = BallNumber.fromString(ballNumberString);
    }

    public boolean readWhetherReGame() throws IllegalArgumentException {
        String whetherReGame = Console.readLine();
        inputValidator.validateWhether(whetherReGame);

        return whetherReGame.equals(YES);
    }
}