package baseball.controller;

import baseball.domain.*;
import baseball.exception.NumberExceptionUtils;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;


public class GameController {

    private final Game game = new Game();
    private final Player player = new Player();
    private Computer computer = new Computer();

    public void run() {
        initGame();
        do {
            playGame();
            checkRestartWhenMaxStrike();
        } while (game.isExitStatus());
    }

    public void initGame() {
        OutputView.printInit();
    }

    public void playGame() {
        OutputView.printInput();
        player.setInputBalls();

        playBaseBall();
        OutputView.printGameResult(game);

        game.clearResult();
    }

    public void checkRestartWhenMaxStrike() {
        if (game.isMaxStrike()) {
            OutputView.printFinish();
            OutputView.printRestart();

            String command = getRestartResponse();
            setActionOfRestartAndExit(command);
        }
    }

    private void playBaseBall() {
        int strikeCount = NumberComparator.getStrikeCount(player.getBalls(), computer.getBalls());
        int ballCount = NumberComparator.getBallCount(player.getBalls(), computer.getBalls());
        game.setGameResult(strikeCount, ballCount);
    }


    private String getRestartResponse() {
        String command = Console.readLine();
        NumberExceptionUtils.isValidCommandDigit(command);
        return command;
    }

    private void setActionOfRestartAndExit(String command) {
        if (GameStatus.isRestart(command)) {
            computer = new Computer();
        } else {
            game.setExitStatus();
        }
    }
}
