package baseball.controller;

import baseball.domain.*;
import baseball.exception.NumberExceptionUtils;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;


public class GameController {

    private final Game game;
    private final Player player;
    private Computer computer;

    public GameController() {
        game = new Game();
        player = new Player();
        computer = new Computer();
    }

    public void run() {
        OutputView.printInit();
        while (!game.isExitStatus()) {
            OutputView.printInput();
            player.setInputBalls();

            playBaseBallGame();
            OutputView.printGameResult(game);

            if (game.isMaxStrike()) {
                String command = getRestartOrExitFromPlayer();
                setActionOfRestartAndExit(command);
            }
            game.clearResult();
        }
    }

    public void playBaseBallGame() {
        player.setInputBalls();
        int strikeCount = NumberComparator.getStrikeCount(player.getBalls(), computer.getBalls());
        int ballCount = NumberComparator.getBallCount(player.getBalls(), computer.getBalls());
        game.setGameResult(strikeCount, ballCount);
    }

    public String getRestartOrExitFromPlayer() {
        OutputView.printFinish();
        OutputView.printRestart();
        String command = Console.readLine();
        NumberExceptionUtils.isValidCommandDigit(command);
        return command;
    }

    public void setActionOfRestartAndExit(String command) {
        if (GameStatus.isRestart(command)) {
            computer = new Computer();
        } else if (GameStatus.isExit(command)) {
            game.setExitStatus();
        }
    }
}
