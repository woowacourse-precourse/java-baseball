package baseball;

import baseball.computer.Computer;
import baseball.rule.Rule;
import baseball.user.User;

public class BaseballGame {
    private final Rule rule;
    private final User user;
    private final Computer computer;

    public BaseballGame() {
        rule = new Rule();
        user = new User();
        computer = new Computer();
    }

    public void start() {
        boolean status = true;
        System.out.println(GameMessage.GAME_START);

        while (status) {
            computer.initComputer();
            playGame();
            status = user.inputOption();
        }
    }

    private void playGame() {
        boolean completeGame = false;

        while (!completeGame) {
            user.inputNumber();
            completeGame = rule.getResult(user.getGameNumber(), computer.getGameNumber());
        }
    }
}
