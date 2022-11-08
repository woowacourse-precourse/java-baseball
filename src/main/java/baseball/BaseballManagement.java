package baseball;

import java.util.List;

public class BaseballManagement {

    private final static int MAX_STRIKE_VALUE = 3;
    private final static String REPLAY_GAME_NUMBER_VALUE = "1";

    public void runBaseballGame() {
        Output.printGameStartMessage();
        boolean isRestart = true;
        while (isRestart) {
            List<Integer> computerRandomNumber = ComputerNumber.generateRandomNumber();
            boolean isThreeStrike = true;
            while (isThreeStrike) {
                NumberCheck numberCheck = new NumberCheck();
                UserNumber userNumber = new UserNumber(Input.inputNumber());
                numberCheck.checkLocationNumbers(userNumber, computerRandomNumber);
                ScoreConfirmation.confirm(numberCheck);
                isThreeStrike = isMatchThreeStrike(numberCheck);
            }
            Output.printGameOverMessage();
            isRestart = isRestartGame();
        }
    }

    private boolean isMatchThreeStrike(NumberCheck numberCheck) {
        return numberCheck.getStrike() != MAX_STRIKE_VALUE;
    }

    private boolean isRestartGame() {
        return Input.inputRestartNumber().equals(REPLAY_GAME_NUMBER_VALUE);
    }

}