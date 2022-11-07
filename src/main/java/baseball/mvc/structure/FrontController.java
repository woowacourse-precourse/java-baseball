package baseball.mvc.structure;

import baseball.domain.game.GameComputer;
import baseball.domain.game.GameResult;
import baseball.mvc.model.Request;
import baseball.mvc.structure.consts.GameModelKeyConst;
import baseball.mvc.structure.consts.GameRequestKeyConst;
import baseball.mvc.view.GameGuideView;
import baseball.mvc.view.GameHintView;
import baseball.util.GameStatus;

public class FrontController {

    private final GameHandlerManager manager = new GameHandlerManager();
    private GameComputer computer;

    public GameStatus process(String playerInput, GameStatus gameStatus) {
        Object handler = manager.getHandler(gameStatus);
        Adapter handlerAdapter = manager.getHandlerAdapter(handler);
        Request request = createRequest(playerInput);

        ModelAndView modelAndView = handlerAdapter.handle(handler, request);
        this.computer = setGameComputer(modelAndView, gameStatus);

        return render(modelAndView, gameStatus);
    }

    private Request createRequest(String playerInput) {
        Request request = new Request();

        request.addAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, playerInput);
        request.addAttribute(GameRequestKeyConst.COMPUTER_KEY, computer);
        return request;
    }

    private GameComputer setGameComputer(ModelAndView modelAndView, GameStatus gameStatus) {
        if (gameStatus == GameStatus.START) {
            return modelAndView.getModelAttribute(GameModelKeyConst.COMPUTER_KEY, GameComputer.class);
        }
        return this.computer;
    }

    private GameStatus render(ModelAndView modelAndView, GameStatus presentStatus) {
        GameStatus nowStatus = modelAndView.getGameStatus();

        printLog(modelAndView, presentStatus, nowStatus);
        return nowStatus;
    }

    private void printLog(ModelAndView modelAndView, GameStatus presentStatus, GameStatus nowStatus) {
        if (presentStatus == GameStatus.PLAY) {
            GameResult result = modelAndView.getModelAttribute(GameModelKeyConst.GAME_RESULT_KEY, GameResult.class);
            GameHintView.printGameHintLog(result);
        }
        if (nowStatus == GameStatus.END) {
            GameGuideView.END.printGuideLog();
        }
    }
}
