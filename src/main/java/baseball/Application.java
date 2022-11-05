package baseball;

import baseball.contoller.BaseballController;
import baseball.domain.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController();
        baseballController.Start();
    }
}
