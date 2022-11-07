package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        Game game = new Game(INPUT_VIEW, OUTPUT_VIEW);
        game.play();
    }
}
