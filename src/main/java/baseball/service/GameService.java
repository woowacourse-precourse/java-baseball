package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Game.GameStatus;
import baseball.domain.Judge;
import baseball.domain.Player;
import baseball.exception.NumberExceptionUtils;
import baseball.util.OutputUtils;
import camp.nextstep.edu.missionutils.Console;


import static baseball.common.Constant.*;
import static baseball.domain.Game.GameStatus.*;



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
        while (!game.getStatus().equals(END)) {
            OutputUtils.printInputView();
            player.setInputBall();

            if (game.getStatus().equals(GameStatus.RESTART)) {
                game.restart();
                computer = new Computer();
            }

            playBaseBallGame();
            OutputUtils.printGameResultView(game);

            if (game.getStrike() == MAX_STRIKE_SIZE) {
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
