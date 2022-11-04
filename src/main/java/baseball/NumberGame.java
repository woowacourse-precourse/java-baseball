package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Validate.*;

abstract public class NumberGame {
    protected String computer;

    abstract public void start();

    abstract public boolean play();

    abstract public boolean end();

    public void setRandomNumber() {
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.computer=String.join("", computer);
    }
}