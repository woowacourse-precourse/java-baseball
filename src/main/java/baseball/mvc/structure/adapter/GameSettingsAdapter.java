package baseball.mvc.structure.adapter;

import baseball.mvc.controller.GameSettingsController;
import baseball.mvc.structure.Adapter;
import baseball.mvc.model.Model;
import baseball.mvc.structure.ModelAndView;
import baseball.mvc.model.Request;
import baseball.util.GameStatus;

public class GameSettingsAdapter implements Adapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof GameSettingsController);
    }

    @Override
    public ModelAndView handle(Object handler, Request request) {
        GameSettingsController controller = (GameSettingsController) handler;
        Model model = new Model();

        GameStatus gameStatus = controller.process(model);
        return createModelAndView(gameStatus, model);
    }

    private ModelAndView createModelAndView(GameStatus gameStatus, Model model) {
        ModelAndView modelAndView = new ModelAndView(gameStatus);

        modelAndView.setModel(model);
        return modelAndView;
    }
}
