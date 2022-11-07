package baseball;

import baseball.View.Message;

public class Application {
    public static void main(String[] args) {
        Message.printStartMessage();
        Controller controller = new Controller();
        controller.run();
    }
}
