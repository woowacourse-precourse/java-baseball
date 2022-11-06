package baseball;


import baseball.controller.GameController;
import baseball.domain.baseballAlgorithm.BaseballAlgorithmImpl;
import baseball.domain.computer.ComputerImpl;
import baseball.domain.referee.RefereeImpl;
import baseball.view.input.InputImpl;
import baseball.view.output.OutputImpl;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new InputImpl(), new OutputImpl(),
                new ComputerImpl(new BaseballAlgorithmImpl()), new RefereeImpl());

        gameController.run();
    }
}
