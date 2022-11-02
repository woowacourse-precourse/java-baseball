package baseball.computer;

import java.util.List;

public class Controller {
    public List<Integer> makeBalls(){
        Computer computer = new Computer();
        computer.makeBalls();
        return computer.getBaseballGameNum();
    }
}
