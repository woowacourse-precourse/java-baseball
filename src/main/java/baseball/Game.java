package baseball;

import baseball.domain.controller.GameController;
import baseball.domain.dto.ResultDto;
import baseball.domain.dto.UserInputDto;
import baseball.domain.model.Ball;
import baseball.domain.view.InputData;
import baseball.domain.view.OutputData;
import java.util.List;

public class Game {

    public static final String INIT_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static final String RESTART_SIGNAL = "1";
    public static final String EXIT_SIGNAL = "2";

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

        boolean isNotProgress = false;
        while (!isNotProgress) {
            List<String> computerBalls = BallGenerator.makeComputerBalls();
            GameController gameController = new GameController(computerBalls);

            playBaseball(gameController);

            if (gameController.restartGame(new UserInputDto(InputData.inputIsGameRestart()))) {
                isNotProgress = true;
            }
        }
    }

    private static void playBaseball(GameController gameController) {
        boolean isThreeStrike = false;
        while (!isThreeStrike) {
            UserInputDto userInputDto = new UserInputDto(InputData.inputUserBallNumber());

            ResultDto resultDto = gameController.doGame(userInputDto);
            OutputData.gameResultPrint(resultDto);

            if (resultDto.getThreeStrike()) {
                isThreeStrike = true;
            }
        }
    }
}
