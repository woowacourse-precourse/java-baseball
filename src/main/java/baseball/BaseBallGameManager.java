package baseball;

import java.util.List;

public class BaseBallGameManager {

    public static final int THREE_STRIKE_NUMBER = 3;
    public static final int GAME_RESET_NUMBER_ONE = 1;
    public static final int RESTART_NUMBER_THREE = 3;

    public void startGame() {
        Output.printGameStart();
        List<Long> computerNumbers = Computer.makeRandomNumber();
        System.out.println(computerNumbers);
        User user = new User(Input.inputUserNumber());
        while (isRestartGameThreeStrike(user, computerNumbers)) {
            RuleManager.compareFourBall(user, computerNumbers);
            RuleManager.compareStrike(user, computerNumbers);
            RuleManager.compareBall(user, computerNumbers);
            RuleManager.compareStrikeBall(user, computerNumbers);
            System.out.println(computerNumbers);
            user = new User(Input.inputUserNumber());
        }
    }

    private boolean isRestartGameThreeStrike(User user, List<Long> computerNumbers) {
        if (RuleManager.countStrike(user, computerNumbers) == THREE_STRIKE_NUMBER) {
            Output.printStrike(RuleManager.countStrike(user, computerNumbers));
            Output.printCorrectAnswer();
            return isRestartGame();
        }
        return true;

    }

    private boolean isRestartGame() {
        int restartNumber = Input.inputRestartNumber();
        if (restartNumber < RESTART_NUMBER_THREE) {
            if (restartNumber == GAME_RESET_NUMBER_ONE) {

                startGame();
            }
        }
        return false;
    }
}
