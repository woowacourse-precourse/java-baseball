package baseball;

import baseball.view.InputViewConsole;
import baseball.view.OutputViewConsole;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new InputViewConsole(), new OutputViewConsole());
        controller.run();
    }
}