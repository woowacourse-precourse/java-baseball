package baseball;

import baseball.model.Ball;
import baseball.model.GameStatus;
import baseball.model.Result;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.service.RefereeService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.utils.Validator.validateGameStatus;
import static baseball.utils.Validator.validateParseStringToInt;

public class Game {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int GAME_RESTART_STATUS = 1;

    private final ComputerService computerService;
    private final PlayerService playerService;
    private final RefereeService refereeService;

    public Game(ComputerService computerService, PlayerService playerService, RefereeService refereeService) {
        System.out.println(START_GAME_MESSAGE);
        this.computerService = computerService;
        this.playerService = playerService;
        this.refereeService = refereeService;
    }

    public void startGame() {
        List<Ball> computerBalls = computerService.generateRandomBalls();

        boolean isGameOver;
        GameStatus gameStatus = new GameStatus(GAME_RESTART_STATUS);
        do {
            List<Ball> playerBalls = playerService.generatePlayerBalls();

            Result result = refereeService.generateResult(computerBalls, playerBalls);
            refereeService.printResult(result);

            isGameOver = result.isGameOver();
            inputGameStatusIfGameOver(gameStatus, isGameOver);
        } while (!isGameOver);

        if (gameStatus.isRestart()) {
            startGame();
        }
    }

    private static void inputGameStatusIfGameOver(GameStatus gameStatus, boolean isGameOver) {
        if(isGameOver) {
            String playerInput = Console.readLine();
            validateParseStringToInt(playerInput);
            gameStatus.changeStatus(Integer.parseInt(playerInput));
            validateGameStatus(gameStatus);
        }
    }

}
