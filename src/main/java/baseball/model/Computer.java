package baseball.model;

import baseball.util.RandomUtil;
import java.util.List;

public class Computer {

    private List<Integer> ballNumber;

    public List<Integer> getBallNumber() {
        return ballNumber;
    }

    public void throwTheBall() {
        ballNumber = RandomUtil.pickNumbers();
    }
}
