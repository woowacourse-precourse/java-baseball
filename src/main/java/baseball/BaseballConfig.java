package baseball;

import baseball.controller.GameController;
import baseball.domain.baseballAlgorithm.BaseballAlgorithm;
import baseball.domain.baseballAlgorithm.BaseballAlgorithmImpl;
import baseball.domain.computer.Computer;
import baseball.domain.computer.ComputerImpl;
import baseball.domain.referee.Referee;
import baseball.domain.referee.RefereeImpl;
import baseball.view.input.Input;
import baseball.view.input.InputImpl;
import baseball.view.output.Output;
import baseball.view.output.OutputImpl;

public class BaseballConfig {

    public GameController gameController() {
        return new GameController(
                input(),
                output(),
                computer(),
                referee());
    }

    public Input input() {
        return new InputImpl();
    }

    public Output output() {
        return new OutputImpl();
    }

    public Computer computer() {
        return new ComputerImpl(baseballAlgorithm());
    }

    public BaseballAlgorithm baseballAlgorithm() {
        return new BaseballAlgorithmImpl();
    }

    public Referee referee(){
        return new RefereeImpl();
    }

}
