package baseball;

import baseball.controller.BaseballController;
import baseball.domain.Baseball;
import baseball.domain.BaseballGame;
import baseball.domain.Player;
import baseball.util.OutputPharse;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    static OutputView outputView = new OutputView();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame(new Player());
        BaseballController baseballController = new BaseballController(new InputView(), new OutputView(), baseballGame);
        baseballController.initController();
        baseballController.play();

    }
}
