package baseball;

import baseball.domain.controller.GameController;
import baseball.domain.dto.UserInputDto;
import baseball.domain.view.InputData;
import baseball.domain.view.OutputData;
import baseball.utils.Ball;
import java.util.List;

public class Game {

    public static final String INIT_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private Game() {
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }

    public void start() {
        System.out.println(INIT_GAME_START_MESSAGE);
        Ball BallGenerator = Ball.getInstance();

        List<String> computerBalls = BallGenerator.makeComputerBalls();
        GameController gameController = new GameController(computerBalls);

        UserInputDto userInputDto = new UserInputDto(InputData.inputUserBallNumber());

        OutputData.gameResultPrint(gameController.doGame(userInputDto));
    }


}
