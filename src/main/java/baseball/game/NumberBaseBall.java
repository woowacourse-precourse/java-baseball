package baseball.game;

import baseball.input.inputInterface.InputAble;
import baseball.input.inputImpl.InputConsole;
import baseball.player.playerImpl.Computer;
import baseball.player.playerImpl.GamePlayer;
import baseball.player.playerMember.PlayerNumbers;
import baseball.uitls.Hints;
import baseball.uitls.RandomNumber;
import baseball.validate.ValidateNumber;
import baseball.view.ViewConsole;
import baseball.view.Viewable;

public class NumberBaseBall implements PlayAble {
    private final int GAME_END_NUMBER = 2;

    private boolean stopGame = false;
    private boolean endGame = false;

    private InputAble input = new InputConsole();
    private Viewable view = new ViewConsole();
    private Computer computer;
    private GamePlayer gamePlayer;

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
        computer = new Computer(new PlayerNumbers(RandomNumber.makeRandomNumber()));
    }

    private void initializeSetting() {
        this.stopGame = false;
        this.endGame = false;
    }

    @Override
    public void play() {
        view.printInput();
        int inputNumber = input.acceptInt();
        gamePlayer = new GamePlayer(new PlayerNumbers(inputNumber));
        Hints hints = computer.judge(gamePlayer.getPlayerNumbers());
        view.printHint(hints);
        if (hints.isStrikeOut()) {
            this.stopGame = true;
        }
    }

    @Override
    public void end() {
        view.printEnd();
        view.printIsContinue();
        int choice = input.acceptInt();
        ValidateNumber.validateInList(choice);
        if (choice == GAME_END_NUMBER) {
            this.endGame = true;
        }
    }
}
