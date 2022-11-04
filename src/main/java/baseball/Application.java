package baseball;

import baseball.controller.GameController;
import baseball.view.AppView;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.run();
    }
}
