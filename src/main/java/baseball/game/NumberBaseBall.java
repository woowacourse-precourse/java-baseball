package baseball.game;

import baseball.input.InputAble;
import baseball.input.InputConsole;
import baseball.player.Computer;
import baseball.player.GamePlayer;
import baseball.validate.ValidateNumber;
import baseball.view.ViewConsole;
import baseball.view.Viewable;

import java.util.List;

public class NumberBaseBall implements PlayAble {
    private final int INPUT_NUMBER_LENGTH = 3;
    private final int STRIKE_INDEX = 1;
    private final int STRIKE_OUT = 3;

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

    @Override
    public void start() {
        initializeSetting();
        view.printStart();
        computer.setNumber(Computer.makeRandomNumber());
    }

    private void initializeSetting() {
        this.stopGame = false;
        this.endGame = false;
    }

    @Override
    public void play() {
        view.printInput();
        int inputNumber = input.acceptInt();
        validateInputNumber(inputNumber);
        gamePlayer.setNumber(inputNumber);
        List<Integer> hints = computer.judge(gamePlayer.getNumber());
        view.printHint(hints);
        if (hints.get(STRIKE_INDEX) == STRIKE_OUT) {
            this.stopGame = true;
        }
    }

    private void validateInputNumber(int inputNumber) {
        ValidateNumber.validateLength(inputNumber, (Integer length) -> length == INPUT_NUMBER_LENGTH);
        ValidateNumber.validateOverlap(inputNumber);
    }

    @Override
    public void end() {

    }
}
