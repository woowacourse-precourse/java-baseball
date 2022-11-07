package baseball.Model;

import baseball.Util.RandomUtil;
import java.util.List;

public class Computer {
    private List<Integer> computerInput;

    public void setComputerInput() {
        computerInput = RandomUtil.randomNum();
    }
}
