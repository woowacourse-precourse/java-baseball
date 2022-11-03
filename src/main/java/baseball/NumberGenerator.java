package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int SIZE = 3;
    private List<Integer> computer = new ArrayList<>();

    public List<Integer> getComputer() {
        return computer;
    }

    public void setComputer(List<Integer> computer) {
        this.computer = computer;
    }

    public void init() {
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (check(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }

    private boolean check(int randomNumber){
        if (!computer.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}
