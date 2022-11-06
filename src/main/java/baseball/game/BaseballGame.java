package baseball.game;

import baseball.player.Computer;
import baseball.player.Human;
import baseball.player.Player;
import baseball.validator.Referee;
import baseball.validator.Validator;

public class BaseballGame implements Game{
    private Player human;
    private Player computer;
    private Validator referee;

    public BaseballGame() {
        this.human = new Human();
        this.computer = new Computer();
        this.referee = new Referee();
    }

    @Override
    public void start() {

    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }
}
