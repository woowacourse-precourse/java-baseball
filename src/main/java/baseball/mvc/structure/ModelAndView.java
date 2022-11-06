package baseball.mvc.structure;

import baseball.mvc.model.Model;
import baseball.util.GameStatus;

public class ModelAndView {

    private final GameStatus gameStatus;
    private Model model;

    public ModelAndView(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public <T> T getModelAttribute(String key, Class<T> type) {
        return model.getAttribute(key, type);
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
