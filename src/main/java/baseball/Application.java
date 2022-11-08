package baseball;

import baseball.controller.Controller;
import baseball.game.BaseballGame;
import baseball.game.Game;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.console.ConsoleInput;
import baseball.view.console.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInput();
        OutputView outputView = new ConsoleOutput();
        Controller controller = Controller.createWithViews(inputView, outputView);

        Game game = new BaseballGame(inputView, outputView);
        controller.runGame(game);
    }
}
