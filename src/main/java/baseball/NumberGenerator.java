package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private List<Integer> computer;

    public List<Integer> getComputer() {
        return computer;
    }

    public void setComputer(List<Integer> computer) {
        this.computer = computer;
    }

    public void init() {
        computer = new ArrayList<>();
        while (computer.size() < ConstGame.SIZE) {
            int randomNumber = Randoms.pickNumberInRange(ConstGame.MIN_RANGE, ConstGame.MAX_RANGE);
            check(randomNumber);
        }
    }

    private void check(int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
