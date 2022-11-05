package baseball.game;

import baseball.input.InputAble;
import baseball.input.InputConsole;
import baseball.player.Computer;
import baseball.player.GamePlayer;
import baseball.validate.ValidateNumber;
import baseball.view.ViewConsole;
import baseball.view.Viewable;

import java.util.List;

public class NumberBaseBall {
    private boolean stopGame = false;
    private boolean endGame = false;

    private InputAble input = new InputConsole();
    private Viewable view = new ViewConsole();
    private Computer computer = new Computer();
    private GamePlayer gamePlayer = new GamePlayer();

    public boolean isStopGame() {
        return stopGame;
    }

    public boolean isEndGame() {
        return endGame;
    }
}
