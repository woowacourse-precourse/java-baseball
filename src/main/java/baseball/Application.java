package baseball;

import baseball.game.GameController;

import static baseball.view.InputView.startProgramView;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startProgramView();
        GameController.start();
    }
}
