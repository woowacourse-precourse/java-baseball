package baseball;

import utils.Input;
import utils.Output;
import utils.RandomNumberGenerator;

import java.util.List;

public class Baseball {
    private List<Integer> computer;

    public Baseball() {
        this.computer = RandomNumberGenerator.generate();
    }

    public void run() {}
}
