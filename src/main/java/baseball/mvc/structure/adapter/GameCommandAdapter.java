package baseball.mvc.structure.adapter;

import baseball.mvc.controller.GameCommandController;
import baseball.mvc.structure.Adapter;
import baseball.mvc.structure.ModelAndView;
import baseball.mvc.structure.Request;
import baseball.mvc.util.GameCommand;
import baseball.mvc.util.GameRequestKeyConst;
import baseball.util.GameStatus;

public class GameCommandAdapter implements Adapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof GameCommandController);
    }

    @Override
    public ModelAndView handle(Object handler, Request request) {
        GameCommandController controller = (GameCommandController) handler;

        String playerInput = request.getAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, String.class);
        GameStatus gameStatus = controller.process(playerInput);

        return new ModelAndView(gameStatus);
    }
}
