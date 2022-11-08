package baseball;

import baseball.controller.BaseballController;
import baseball.message.Messages;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(Messages.START_GAME);
        BaseballController.run();
    }
}
