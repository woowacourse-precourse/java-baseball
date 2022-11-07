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
        while (game.isExitStatus()) {
            OutputUtils.printInputView();
            player.setInputBall();

            if (game.isRestartStatus()) {
                game.restartGame();
                computer = new Computer();
            }

            playBaseBallGame();
            OutputUtils.printGameResultView(game);

            if (game.isMaxStrike()) {
                String command = getRestartOrExitFromPlayer();
                game.setStatusByCommand(command);
            }

            game.clearResult();
        }
    }

    public String getRestartOrExitFromPlayer() {
        OutputUtils.printFinishView();
        OutputUtils.printRestartView();
        String command = Console.readLine();
        NumberExceptionUtils.isValidCommandDigit(command);
        return command;
    }

    public void playBaseBallGame() {
        int strikeCount = Judge.getStrikeCount(player.getBall(), computer.getBall());
        int ballCount = Judge.getBallCount(player.getBall(), computer.getBall());
        game.setGameResult(strikeCount, ballCount);
    }
}
