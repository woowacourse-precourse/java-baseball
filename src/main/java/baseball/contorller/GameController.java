package baseball.contorller;

import baseball.domain.Ball;
import baseball.domain.Config;
import baseball.domain.Flag;
import baseball.service.GameService;
import baseball.view.Views;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    public void start() {
        service.startGame();
        Views.INITIAL_VIEW.getView().view();

            checkHint();
    }

    public void checkHint() {
        Views.INPUT_VIEW.getView().view();
    }
    }
}
