package baseball.controller;

import baseball.domain.*;
import baseball.exception.NumberValidator;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;


public class GameController {

    private final Game game;
    private Player player;
    private Computer computer;

    public GameController(Game game, Computer computer) {
        this.game = game;
        this.computer = computer;
    }

    public void run() {
        initGame();
        do {
            playGame();
            String command = checkRestartWhenMaxStrike();
            setActionOfRestartAndExit(command);
        } while (!game.isExitStatus());
    }

    public void initGame() {
        OutputView.printInit();
    }

    public void playGame() {
        OutputView.printInput();
        player = Player.create();
        game.playBaseBall(player, computer);
        OutputView.printGameResult(game);
    }

    public String checkRestartWhenMaxStrike() {
        if (!game.isMaxStrike()) {
           return GameStatus.PROGRESS.number();
        }

        OutputView.printFinishAndRestart();
        return getRestartResponse();
    }

    protected String getRestartResponse() {
        String command = Console.readLine();
        NumberValidator.isValidCommandDigit(command);
        return command;
    }

    public void setActionOfRestartAndExit(String command) {
        isRestartGenerateNewComputer(command);
        isExitSetGameStatus(command);
        game.clearResult();
    }

    private void isRestartGenerateNewComputer(String command) {
        if (GameStatus.isRestart(command)) {
            computer = Computer.createComputer();
        }
    }

    private void isExitSetGameStatus(String command) {
        if (GameStatus.isExit(command)) {
            game.setExitStatus();
        }
    }
}
