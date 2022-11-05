package baseball;

import baseball.controller.ComputerController;
import baseball.controller.PlayerController;
import baseball.controller.RefereeController;
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

public class Application {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int GAME_RESTART_STATUS = 1;

    public static void main(String[] args) {
        System.out.println(START_GAME_MESSAGE);
        ComputerController computerController = new ComputerController(new ComputerService());
        PlayerController playerController = new PlayerController(new PlayerService());
        RefereeController refereeController = new RefereeController(new RefereeService());

        startGame(computerController, playerController, refereeController);
    }

    private static void startGame(ComputerController computerController, PlayerController playerController, RefereeController refereeController) {
        List<Ball> computerBalls = computerController.generateRandomBalls();

        boolean isGameOver;
        GameStatus gameStatus = new GameStatus(GAME_RESTART_STATUS);
        do {
            List<Ball> playerBalls = playerController.generatePlayerBalls();

            Result result = refereeController.generateResult(computerBalls, playerBalls);
            refereeController.printResult(result);

            isGameOver = result.isGameOver();
            inputGameStatusIfGameOver(gameStatus, isGameOver);
        } while (!isGameOver);

        if (gameStatus.isRestart()) {
            startGame(computerController, playerController, refereeController);
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
