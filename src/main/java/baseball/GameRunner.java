package baseball;

import baseball.mvc.structure.FrontController;
import baseball.mvc.exception.ApplicationRuntimeException;
import baseball.mvc.view.GameGuideView;
import baseball.mvc.view.GameInputView;
import baseball.util.GameStatus;
import camp.nextstep.edu.missionutils.Console;

public final class GameRunner {

    private static final String DEFAULT_PLAYER_INPUT = "";
    private static final FrontController FRONT_CONTROLLER = new FrontController();

    private GameRunner() {
    }

    public static void run() {
        GameStatus gameStatus = GameStatus.START;
        GameGuideView.START.printGuideLog();

        while (isPlay(gameStatus)) {
            GameInputView.printGameInputLog(gameStatus);
            String playerInput = inputCommand(gameStatus);
            gameStatus = processFrontController(playerInput, gameStatus);
        }
    }

    private static GameStatus processFrontController(String playerInput, GameStatus gameStatus) {
        try {
            return FRONT_CONTROLLER.process(playerInput, gameStatus);
        } catch (NullPointerException e) {
            throw new ApplicationRuntimeException(e);
        }
    }

    private static boolean isPlay(GameStatus gameStatus) {
        return gameStatus != GameStatus.EXIT;
    }

    private static String inputCommand(GameStatus gameStatus) {
        String playerInput = DEFAULT_PLAYER_INPUT;

        if (gameStatus != GameStatus.START) {
            playerInput = Console.readLine();
        }
        return playerInput;
    }
}
