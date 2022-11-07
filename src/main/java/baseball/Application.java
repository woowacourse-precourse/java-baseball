package baseball;

import baseball.computer.Computer;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.displayGameStartMessage();
        programStart();
    }

    private static void programStart() {
        Computer.init();
    }
}
