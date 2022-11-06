package baseball;

import baseball.dto.GameStatus;
import baseball.dto.Result;
import baseball.model.*;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int GAME_RESTART_STATUS = 1;

    private final Computer computer;
    private final Player player;
    private final Referee referee;

    public Game(Computer computer, Player player, Referee referee) {
        System.out.println(START_GAME_MESSAGE);
        this.computer = computer;
        this.player = player;
        this.referee = referee;
    }

    public void startGame() {
        Balls computerBalls = computer.generateRandomBalls();

        GameStatus gameStatus = new GameStatus(GAME_RESTART_STATUS);
        do {
            Balls playerBalls = player.generatePlayerBalls();
            Result result = referee.doJudge(computerBalls, playerBalls);
            referee.printResult(result);

            if (result.isGameOver()) {
                inputGameStatusIfGameOver(gameStatus);
                break;
            }
        } while (true);

        if (gameStatus.isRestart()) {
            startGame();
        }
    }

    private static void inputGameStatusIfGameOver(GameStatus gameStatus) {
        String playerInput = Console.readLine();
        gameStatus.changeStatus(playerInput);
    }
}
