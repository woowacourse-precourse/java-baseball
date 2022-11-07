package baseball.mvc.structure.adapter;

import baseball.domain.game.GameComputer;
import baseball.domain.number.GameNumbers;
import baseball.mvc.controller.GamePlayController;
import baseball.mvc.structure.Adapter;
import baseball.mvc.model.Model;
import baseball.mvc.structure.ModelAndView;
import baseball.mvc.model.Request;
import baseball.mvc.structure.consts.GameRequestKeyConst;
import baseball.util.GameStatus;

public class GamePlayAdapter implements Adapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof GamePlayController);
    }

    @Override
    public ModelAndView handle(Object handler, Request request) {
        GamePlayController controller = (GamePlayController) handler;
        GameComputer computerAnswer = request.getAttribute(GameRequestKeyConst.COMPUTER_KEY, GameComputer.class);
        String playerInput = request.getAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, String.class);
        GameNumbers playerAnswer = new GameNumbers(playerInput);

        Model model = new Model();
        GameStatus gameStatus = controller.process(computerAnswer, playerAnswer, model);

        return createModelAndView(gameStatus, model);
    }

    private ModelAndView createModelAndView(GameStatus gameStatus, Model model) {
        ModelAndView modelAndView = new ModelAndView(gameStatus);

        modelAndView.setModel(model);
        return modelAndView;
    }
}
