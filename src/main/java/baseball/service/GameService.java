package baseball.service;

import baseball.domain.*;
import baseball.exception.NumberExceptionUtils;
import baseball.util.OutputUtils;
import camp.nextstep.edu.missionutils.Console;


public class GameService {

    private final Game game;
    private final Player player;
    private Computer computer;

    public GameService() {
        game = new Game();
        player = new Player();
        computer = new Computer();
    }

    public void run() {
        OutputUtils.printInitView();
        while (!game.isExitStatus()) {
            OutputUtils.printInputView();
            player.setInputBalls();

            playBaseBallGame();
            OutputUtils.printGameResultView(game);

            if (game.isMaxStrike()) {
                String command = getRestartOrExitFromPlayer();
                setActionOfRestartAndExit(command);
            }
            game.clearResult();
        }
    }

    public void playBaseBallGame() {
        player.setInputBalls();
        int strikeCount = Judge.getStrikeCount(player.getBalls(), computer.getBalls());
        int ballCount = Judge.getBallCount(player.getBalls(), computer.getBalls());
        game.setGameResult(strikeCount, ballCount);
    }

    public String getRestartOrExitFromPlayer() {
        OutputUtils.printFinishView();
        OutputUtils.printRestartView();
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
